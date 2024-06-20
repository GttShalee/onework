package cn.shalee.interceptors;

import cn.shalee.pojo.Result;
import cn.shalee.utils.JwtUtil;
import cn.shalee.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/9 12:56
 * @注释
 */

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //令牌验证
        String token = request.getHeader("Student");

        try {
            Map<String, Object> claims = JwtUtil.parseToken(token);
            //存储在ThreadLocal
            ThreadLocalUtil.set(claims);
            return true;
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //  清空ThreadLocal数据
        ThreadLocalUtil.remove();
    }
}
