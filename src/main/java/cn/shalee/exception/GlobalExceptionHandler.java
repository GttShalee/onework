package cn.shalee.exception;

import cn.shalee.pojo.Result;
import jakarta.servlet.annotation.HandlesTypes;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.StringUtil;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/9 12:00
 * @注释
 */

@RestController
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        e.printStackTrace();
        return Result.error(StringUtils.hasLength(e.getMessage()) ? e.getMessage() : "操作失败");
    }
}
