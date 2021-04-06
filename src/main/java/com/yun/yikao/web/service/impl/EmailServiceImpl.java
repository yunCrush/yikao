package com.yun.yikao.web.service.impl;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.yun.yikao.web.dataobject.Yikao;
import com.yun.yikao.web.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

/**
 * @Author: Crush
 * @Date:2021/3/28 19:31
 * Description:
 */
@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    DefaultKaptcha kaptcha;

    @Override
    public void send(HttpSession session, String email) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("yunfei66641@163.com");
            helper.setTo(email);
            helper.setSubject("主题： 验证码");
            String code = kaptcha.createText();
            session.setAttribute("sessionEmailCode", code);
            message.setText("<h1>" + code + "</h1>", "utf-8", "html");
            mailSender.send(message);
            log.info("邮箱验证码发送完成，sessionEmailCode:{}",code);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public String check(Yikao yikao,BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("Yikao", yikao);

            return "index-email";
        } else {
            return "success";

        }
    }
}
