package com.yun.yikao.web.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.yun.yikao.web.service.KapachaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author: Crush
 * @Date:2021/3/14 15:31
 * Description: 图片验证码控制类
 */
@Controller
public class CaptchaController {

    @Autowired
    private KapachaService kapatchaService;

    /**
     *  图片验证码接口
     * @param response
     * @param session
     * @throws IOException
     */
    @RequestMapping(path = "/getCaptcha")
    public void getCaptcha(HttpServletResponse response, HttpSession session) throws IOException {
        kapatchaService.getCaptcha(response, session);
    }

    /**
     * 校验图片验证码与session中比较
     */
    @RequestMapping("checkCaptcha")
    public String checkCaptcha(@RequestParam("captcha") String captcha, HttpSession session) {
        String sessionCaptcha = session.getAttribute("captcha").toString();
        return sessionCaptcha != null && captcha.equals(sessionCaptcha) ? "success" : "index-captcha";

    }

    @RequestMapping("toCaptcha")
    public String toCaptcha() {
        return "index-captcha";
    }


    // Spring 启动时初始化Bean实例
    @Bean
    public DefaultKaptcha initKaptcha() {

        DefaultKaptcha kaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.put(Constants.KAPTCHA_IMAGE_WIDTH, "120");
        properties.put(Constants.KAPTCHA_IMAGE_HEIGHT, "40");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "32");
        Config config = new Config(properties);
        kaptcha.setConfig(config);
        return kaptcha;
    }

}
