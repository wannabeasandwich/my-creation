package cn.tedu.controller;


import cn.tedu.entity.User;
import cn.tedu.mapper.UserMapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
@Api(tags = "4.用户处理类")
@RestController
public class UserController {
    @Autowired
    private UserMapper mapper;

    //在参数列表中声明session,即可得到当前客户端所对应的session(一个登录用户对应一个session)
    @PostMapping("user/login")
    public int login(@RequestBody User user, HttpSession session) {
        User u = mapper.selectByUsername(user.getUsername());
        if (u == null) return 2; //2表示用户名不存在
        //user代表用户输入的信息,包括:用户名和密码
        //u代表从数据库中查询到的信息,包括:id,用户名,密码,昵称
        if (u.getPassword().equals(user.getPassword())) {
            //把当前登录的用户对象保存到会话对象中
            session.setAttribute("user",u);
            return 1; //1表示密码正确
        }
        return 3; //2表示密码不正确
    }

    @GetMapping("user/currentUser")
    public User currentUser(HttpSession session) {
        //获取登录成功时保存在session中的用户信息
        return (User)session.getAttribute("user");
    }

    @GetMapping("user/logout")
    public void logout(HttpSession session) {
        //将登录成功时保存的用户信息移除
        session.removeAttribute("user");
    }
}
