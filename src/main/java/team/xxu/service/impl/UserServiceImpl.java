package team.xxu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import team.xxu.dao.ArticleDao;
import team.xxu.service.UserService;
import team.xxu.dao.UserDao;
import team.xxu.model.User;
/**
 * Created by 26096 on 2017/7/15.
 */
//@Service("UserService") 注解用于标示此类为业务层组件,在使用时会被注解的类会自动由
//spring进行注入,无需我们创建实例
@Service("UserService")
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userMapper;
    @Autowired
    ArticleDao articleMapper;

    //登录方法的实现,从jsp页面获取username与password
    public User login(String username, String password) {
        //对输入账号进行查询,取出数据库中保存对信息
        User user = userMapper.selectByName(username);
        if (user != null) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;

        }
        return null;

    }

    //注册方法的实现，从注册页面获取用户信息
    public User register(User user){
        int a = userMapper.addUser(user);
        if(a>0)
            return user;
        else
            return null;
    }

    //验证用户名是否重复
    public boolean hasUsername(String username){
        User user = userMapper.selectByName(username);
        if(user==null)
            return false;
        else
            return true;
    }

    //更新用户的密码或昵称
    public boolean updateOneUser(User user){
        int message1 = userMapper.updateById(user);
        int message2 = articleMapper.updateAuthor(user.getId(),user.getNickname());
        if(message1>0&&message2>0)
            return true;
        else
            return false;
    }
}
