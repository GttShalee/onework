package cn.shalee.anno;

import cn.shalee.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotEmpty;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/9 19:42
 * @注释
 */

@Documented    //元注解
@Constraint(validatedBy = { StateValidation.class })  //提供校验规则的类
//元注解
@Target({FIELD})
//元注解 标识在哪个阶段被保留（RUNTIME）
@Retention(RUNTIME)

public @interface State {

    String message() default "{state参数的值只能是以批改和未批改}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
