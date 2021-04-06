package com.yun.yikao.web.config;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Crush
 * @Date:2021/3/14 14:52
 * Description:
 */
@Component
public class AuthHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
// 判断当前请求方法是否有@NeedIN是否需要登陆
            NeedLogin needLogin = handlerMethod.getMethodAnnotation(NeedLogin.class);
            if (needLogin != null) {
                if (request.getSession().getAttribute("name") != null) {
                    return true;
                } else {
                    response.sendRedirect("index.html");
                    return false;
                }
            }

        }
        return true;
    }
}
