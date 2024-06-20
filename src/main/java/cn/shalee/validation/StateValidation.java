package cn.shalee.validation;

import cn.shalee.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/9 19:55
 * @注释
 */
public class StateValidation implements ConstraintValidator<State,String> {


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //提供校验规则
        if (value == null) {
            return false;
        }
        if (value.equals("已批改") || value.equals("未批改")){
            return true;
        }
        return false;
    }
}
