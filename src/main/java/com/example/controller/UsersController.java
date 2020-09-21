package com.example.controller;

import com.example.entity.PageBean;
import com.example.entity.Product;
import com.example.entity.Producttype;
import com.example.entity.Role;
import com.example.entity.Users;
import com.example.service.UsersService;
import com.example.util.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

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
     *
     * @return
     */
    @GetMapping("/indexpage")
    public String login() {
        return "login";
    }

    /**
     * 登录
     *
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
     *
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public String userLogout(HttpSession session) {
        session.invalidate();
        return "login";
    }

    @GetMapping("/getusersbypage")
    public String getUsersByPage(Model model,
                                 @RequestParam(name = "uname", defaultValue = "") String uname,
                                 @RequestParam(name = "roleid", defaultValue = "-1") int roleid,
                                 @RequestParam(name = "page", defaultValue = "1") int page) {
        int pageSize = 5;
        PageBean<HashMap<String, Object>> pageBean = usersServiceImpl.getUsersByPage(page, pageSize, uname, roleid);
        List<Role> list = usersServiceImpl.getRoleList();

        model.addAttribute("pagebean", pageBean);
        model.addAttribute("rolelist", list);
        model.addAttribute("uname", uname);
        model.addAttribute("roleid", roleid);
        return "usersbypage";
    }

    @GetMapping("/delusers")
    public String delUsers(int id) {
        usersServiceImpl.delUsers(id);
        return "redirect:getusersbypage";
    }

    @GetMapping("/batchdelusers")
    public String batchDelUsers(int[] ids) {
        usersServiceImpl.batchDelUsers(ids);
        return "redirect:getusersbypage";
    }

    @PostMapping("/usrupload")
    @ResponseBody
    public Map<String, String> uploadFile(MultipartFile upimage, HttpServletRequest request) {
        //获取文件名称
        String fileName = upimage.getOriginalFilename();
        String ext = fileName.substring(fileName.indexOf("."));
        //上传文件的名称
        String realName = UUID.randomUUID().toString() + ext;
        //服务器路径
        String serverPath = request.getServletContext().getRealPath("/") + "/resources/image_user/";
        Map<String, String> result = new HashMap<>();
        File file = new File(serverPath + realName);
        try {
            upimage.transferTo(file);
            result.put("imgurl", request.getContextPath() + "/resources/image_user/" + realName);
            result.put("imgName", realName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result.toString());
        return result;
    }

    @GetMapping("/adduserspage")
    public String toAddUsersPage(Model model) {
        List<Role> list = usersServiceImpl.getRoleList();
        model.addAttribute("rolelist", list);
        return "addusers";
    }

    @PostMapping("/addusers")
    public String addusers(Users users) {
        users.setUpass(MD5Util.getMd5Str(users.getUpass()));
        usersServiceImpl.addUser(users);
        return "redirect:getusersbypage";
    }


    @GetMapping("/updateuserspage")
    public String toUpdateUsersPage(int id, Model model) {
        Users users = usersServiceImpl.getUserById(id);
        model.addAttribute("users", users);
        List<Role> producttypes = usersServiceImpl.getRoleList();
        model.addAttribute("rolelist", producttypes);
        return "updateusers";
    }

    @PostMapping("/updateusers")
    public String upDateUsers(Users users) {
        Users user = usersServiceImpl.getUserById(users.getUid());

        if (users.getUimage() == null || users.getUimage() == "") {
            users.setUimage(user.getUimage());
        }
        usersServiceImpl.updateUser(users);
        return "redirect:getusersbypage";
    }
}
