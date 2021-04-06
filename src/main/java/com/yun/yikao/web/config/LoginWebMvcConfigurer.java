package com.yun.yikao.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: Crush
 * @Date:2021/3/14 14:53
 * Description:
 */
@Configuration
public class LoginWebMvcConfigurer implements WebMvcConfigurer {
    @Autowired
    private AuthHandlerInterceptor authHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
// ("/**")拦截所有方法，排除部分请求excludePathPatterns()
        registry.addInterceptor(authHandlerInterceptor).addPathPatterns("/**");
    }
}
