package com.yun.yikao.web.service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: Crush
 * @Date:2021/3/29 19:31
 * Description:
 */
public interface KapachaService {
    void getCaptcha(HttpServletResponse response, HttpSession session) throws IOException;
}
