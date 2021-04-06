package com.yun.yikao.web.controller;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author: Crush
 * @Date:2021/3/26 23:10
 * Description: 全局异常捕获
 */
@Controller
public class GlobalExceptionHandler implements ErrorViewResolver {
    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("url",request.getRequestURL());
        modelAndView.addAllObjects(model);
        modelAndView.setViewName("errorPage");
        return modelAndView;
    }
}