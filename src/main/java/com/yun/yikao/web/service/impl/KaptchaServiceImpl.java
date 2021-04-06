package com.yun.yikao.web.service.impl;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.yun.yikao.web.service.KapachaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author: Crush
 * @Date:2021/3/29 19:33
 * Description:
 */
@Service
public class KaptchaServiceImpl implements KapachaService {

    @Autowired
    private DefaultKaptcha kaptcha;

    @Override
    public void getCaptcha(HttpServletResponse response, HttpSession session) throws IOException {
// set to expir far in the past.
        response.setDateHeader("Expires", 0);
// set standard HTTP/1.1 no-cahce heaeders.
        response.setHeader("Cache-Control", "no-cache,must-revalidate");
// set IE extended HTTP/1.1 no-cahce header (use addHeader);
        response.addHeader("Cache-Control", "post-check=0,pre-check=0");
// set standard HTTP/1.0 no-cahce header.
        response.setHeader("Pragma", "no-cache");
// 设置内容格式
        response.setContentType("image/png");
// 创建随机数
        String capText = kaptcha.createText();
// store the text in the image
// 将随机数存储到session里面
        session.setAttribute("captcha", capText);
// session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
// 图片的输出
        BufferedImage bi = kaptcha.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "png", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }
}
