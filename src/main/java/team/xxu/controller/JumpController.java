package team.xxu.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import team.xxu.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by 26096 on 2017/7/16.
 */
@Controller
@Scope("prototype")
public class JumpController {
    //跳转到登录页面
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        return "login";
    }

    //跳转到注册页面
    @RequestMapping("/register")
    public String register(HttpServletRequest request){
        return "register";
    }

    //跳转到文章上传页面
    @RequestMapping("/article")
    public String articel(HttpServletRequest request){
        request.setAttribute("update",false);
        return "article";
    }

    //跳转到用户信息页面
    @RequestMapping("/userInfo")
    public String getUserInfo(HttpServletRequest request){
        return "userInfo";
    }
}
