package com.yun.yikao.web.dataobject;

import com.yun.yikao.web.validator.EmailCode;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author: Crush
 * @Date:2021/3/14 15:06
 * Description:
 */
@Data
public class Yikao  implements Serializable {
 @NotBlank(message = "邮箱不能为空")
private String email;
// message没有，默认message在@EmaiilCode注解里
 @EmailCode()
 private  String emailCode;

}
