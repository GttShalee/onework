package cn.shalee.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/8 16:08
 * @注释
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {


    // 0=>success   -1 =>error
    private String code;
    private String msg;
    private Object data;

    public static Result success(Object data) {
        return new Result("0", "success", data);
    }

    public static Result success() {
        return new Result("0", "success", null);
    }

    public static Result error(String msg) {
        return new Result("-1", msg, null);
    }


}
