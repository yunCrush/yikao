package com.yun.yikao.web.controller;


import com.yun.yikao.web.dataobject.Yikao;
import com.yun.yikao.web.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @Author: Crush
 * @Date:2021/3/14 15:33
 * Description: 邮箱验证码实现
 */
@Slf4j
@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("/sendemail")
    @ResponseBody
    public void send(HttpSession session, @RequestParam("email") String email) {
        emailService.send(session,email);
    }

// 判断验证码及邮箱有验证码是否正确，不正确返回注册页面
    @RequestMapping(path = "/checkemailcode")
    public String check(@Valid Yikao yikao, BindingResult result, RedirectAttributes redirectAttributes,
                              HttpSession session){
        if(session.getAttribute("sessionEmailCode")==null){
            log.info("session不存在sessionEmailCode，跳转注册页面");
            return "index-email";
        }
       return  emailService.check(yikao,result,redirectAttributes);
    }

    /**
     * 邮箱验证码接口
     * @param yikao
     * @return
     */
    @RequestMapping("/toEmail")
    public ModelAndView toEmail(Yikao yikao){
        ModelAndView view = new ModelAndView();
        view.addObject("yikao", yikao);
        view.setViewName("index-email");
        log.info("进入邮箱验证界面");
        return view;
    }

}
