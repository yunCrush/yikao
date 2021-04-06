package com.yun.yikao.web.controller;

import com.yun.yikao.web.config.NeedLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @Author: Crush
 * @Date:2021/3/14 17:33
 * Description: 登陆，
 */
@Slf4j
@Controller
public class LoginController {

    /**
     * 测试@NeedLogin注解
     * @return
     */
    @RequestMapping("/testNeedLogIn")
    @NeedLogin
    public String toSuccess(){
        log.info("@NeedLogIn注解测试成功");
        return "success";
    }


    /**
     * 登陆接口
     * @param name
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("/signup")
    public String signup(@RequestParam("name") String name,
                         @RequestParam("password") String password, HttpSession session){
        if( "yuncrush".equals(password)){
            session.setAttribute("name",name);
            log.info("登陆成功,{}",name);
            return "success";
        }
        return "signup";
    }

    /**
     * 登出会话接口
     * @param session
     * @return
     */
    @RequestMapping("/signout")
    @ResponseBody
    public String signout(HttpSession session) {
        log.info("退出当前会话,{}",session.getAttribute("name"));
        session.removeAttribute("name");
        return "退出成功";
    }
}
