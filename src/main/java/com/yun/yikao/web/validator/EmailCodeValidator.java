package com.yun.yikao.web.validator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author: Crush
 * @Date:2021/3/14 15:13
 * Description: 验证码注解实现类，与session里value比较
 */
@Slf4j
public class EmailCodeValidator implements ConstraintValidator<EmailCode, String> {
    @Autowired
    private HttpServletRequest request;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String emailCode = (String) request.getSession().getAttribute("sessionEmailCode");
        log.info("邮箱验证码校验开始：");
        return StringUtils.equals(value, emailCode);
    }
}
