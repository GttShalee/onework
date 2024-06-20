package cn.shalee.controller;

import cn.shalee.pojo.Result;
import cn.shalee.utils.JwtUtil;
import com.auth0.jwt.interfaces.Header;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/9 12:14
 * @注释
 */

@RestController
@RequestMapping("/work")
public class WorkController {

    @GetMapping("/list")
    public Result list() {
        //验证token
        return Result.success("123456");
    }
}
