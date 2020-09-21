package com.example.controller;

import com.example.entity.Users;
import com.example.service.UsersService;
import com.example.util.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author:TTF
 * @date:2020/9/15
 */
@Controller
public class UsersController {

    @Resource
    private UsersService usersServiceImpl;

    /**
     * 跳转到登录界面
     * @return
     */
    @GetMapping("/indexpage")
    public String login() {
        return "login";
    }

    /**
     * 登录
     * @param users
     * @param model
     * @param session
     * @return
     */
    @PostMapping("/login")
    public String userLogin(Users users, Model model, HttpSession session) {
        users.setUpass(MD5Util.getMd5Str(users.getUpass()));

        HashMap<String, Object> user = usersServiceImpl.userLogin(users);

        if (Objects.isNull(user)) {
            model.addAttribute("info", "账号或密码错误");
            return "login";
        }
        session.setAttribute("users", user);
        return "main";
    }

    /**
     * 登出
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public String userLogout(HttpSession session) {
        session.invalidate();
        return "login";
    }

    @GetMapping("/getusersbypage")
    public String getUsersByPage() {


        return "";
    }
}
