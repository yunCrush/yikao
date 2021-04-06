package com.yun.yikao.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Author: Crush
 * @Date:2021/3/14 15:47
 * Description: 统计在线人数
 */
@Slf4j
@WebListener
@RestController
public class CountController implements HttpSessionListener {
    public static int online = 0;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();

        System.out.println("创建session");
        online=online+1;
        log.info("创建seesion: {}",session.getId());
        log.info("在线人数：{}",online);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        online=online-1;
        HttpSession session = se.getSession();
        log.info("销毁session: {}",session.getAttribute("name"));
        log.info("在线人数：{}",online);

    }
    @RequestMapping("/getOnline")
    public String getOnlie(){
        return online+ " ";
    }

}
