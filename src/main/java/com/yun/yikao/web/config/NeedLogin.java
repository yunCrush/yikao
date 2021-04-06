package com.yun.yikao.web.config;

import java.lang.annotation.*;

/**
 * @Author: Crush
 * @Date:2021/3/14 14:57
 * Description:
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface NeedLogin {
}
