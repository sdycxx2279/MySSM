package team.xxu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import team.xxu.model.User;
import team.xxu.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by 26096 on 2017/7/15.
 */
//@Controller注解用于标示本类为web层控制组件
@Controller
//@RequestMapping("/user")用于标定访问时对url位置
@RequestMapping("/user")
//在默认情况下springmvc的实例都是单例模式,所以使用scope域将其注解为每次都创建一个新的实例
@Scope("prototype")
public class UserController {
    //自动注入业务层的userService类
    @Autowired
    UserService userService;

    //login业务的访问位置为/user/login
    @RequestMapping("/login")
    public String login(User user,HttpServletRequest request){
        //调用login方法来验证是否是注册用户
        User loginUser = userService.login(user.getUsername(),user.getPassword());
        if(loginUser!=null){
            //如果验证通过,则将用户信息传到前台
            HttpSession session = request.getSession();
            session.setAttribute("LoginUser",loginUser);

            //并跳转到index.jsp页面
            return "redirect:/article/allArticles.do";
        }else{
            //若不对,则将错误信息显示到错误页面
            request.setAttribute("message","用户名密码错误");
            return "WEB-INF/jsp/login.jsp";
        }
    }

    //注册
    @RequestMapping("/register")
    public String register(User user,HttpServletRequest request){
        if(user.getUsername()=="")
            request.setAttribute("message","用户名不可为空");
        else if(user.getPassword()=="")
            request.setAttribute("message","密码不可为空");
        else if(user.getNickname()=="")
            request.setAttribute("message","昵称不可为空");
        else if(userService.hasUsername(user.getUsername()))
            request.setAttribute("message","账号已被注册");
        else{
            User loginUser = userService.register(user);
            if(loginUser!=null){
                System.out.println(loginUser.toString());
                HttpSession session = request.getSession();
                session.setAttribute("LoginUser",loginUser);

                //并跳转到index.jsp页面
                return "redirect:/article/allArticles.do";
            }
            else
                request.setAttribute("message","系统错误");
        }
        return "WEB-INF/jsp/register.jsp";
    }

    //更新用户信息
    @RequestMapping("update")
    public String updateUser(User user,HttpServletRequest request){
        if(user.getPassword()=="")
            request.setAttribute("message","密码不可为空");
        else if(user.getNickname()=="")
            request.setAttribute("message","昵称不可为空");
        else{
            HttpSession session = request.getSession();
            User loginUser = (User)session.getAttribute("LoginUser");
            user.setId(loginUser.getId());

            boolean message = userService.updateOneUser(user);
            if(message){
                user.setUsername(loginUser.getUsername());
                session.setAttribute("LoginUser",user);
                return "redirect:/article/allArticles.do";
            }
            else
                request.setAttribute("message","更新失败");
        }

        return "WEB-INF/jsp/userInfo.jsp";
    }
}
