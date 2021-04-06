package com.yun.yikao.web.service;

import com.yun.yikao.web.dataobject.Yikao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @Author: Crush
 * @Date:2021/3/28 19:30
 * Description:
 */
public interface EmailService {
    void send(HttpSession session, String email);

    String check(Yikao yikao, BindingResult result,
                 RedirectAttributes redirectAttributes);
}
