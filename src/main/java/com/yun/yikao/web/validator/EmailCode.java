package com.yun.yikao.web.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Author: Crush
 * @Date:2021/3/14 15:12
 * Description: 验证码注解
 */
@Documented
@Constraint(validatedBy = EmailCodeValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface EmailCode {
    String message() default "验证码验证失败!!!!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
