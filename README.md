# 登陆验证平台项目
技术栈： Java8、SpringMVC、SpringBoot、Spring session、Thymeleaf

**项目背景**

　　图片与邮箱验证码:进行部分流量限制。

　　表单数据回传：用户常常面临的一个场景是这样的，在邮箱栏输入邮箱，验证码填写栏输入验证码，但是如果用户的验证码如果填写错误，用户需要重新输入邮箱，表单数据回传实现的功能就是将用户上次输入邮箱信息，回传到新页面的输入框，提高用户体验。

　　自定义验证注解：常见的注解有输入框中信息，不为空，或者信息的长度限制。这里与其它不同的是根据元注解自定义实现的邮箱验证码注解，后续无需关注邮箱验证码的判断，实现代码分离，关注其它逻辑业务。在邮箱验证码不正确时，页面会作出相应提示。

　　全局异常处理：当用户输入了错误的访问地址时，应当返回一个友好的报错页面，而非404 not found，满屏代码之类。
  
  **测试地址:**
  
　　图片验证码: http://localhost:9000/toCaptcha
  　点击图片即可刷新验证码
  
  <div align=center><img width="500" height="250" src="https://user-images.githubusercontent.com/46308363/118483588-c379cd80-b748-11eb-96f1-7068fece9858.png"/></div>
  
  邮箱验证码: http://localhost:9000/toEmail
  <div align=center><img width="500" height="250" src="https://user-images.githubusercontent.com/46308363/118483776-05a30f00-b749-11eb-831b-80366021a676.png"/></div>

  邮箱验证码功能包含数据回显，对于用户输入的数据无需再次输入。


