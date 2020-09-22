package com.example.controller;

import com.example.entity.Customer;
import com.example.service.CustomerService;
import com.example.util.MD5Util;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author : TTF
 * @date : 2020/9/22
 */
@Controller
public class CustomerController {

    @Resource
    private CustomerService customerServiceImpl;

    @GetMapping("/toregisterpage")
    public String toRegisterPage() {
        return "register";
    }

    @GetMapping("/tocustomerloginpage")
    public String toLoginPage() {
        return "customerlogin";
    }

    @PostMapping("/docheckcname")
    public HashMap<String, String> doCheckCname(String cname) {
        HashMap<String, String> result = new HashMap<>();
        Customer customer = customerServiceImpl.getCustomerByCname(cname);

        if (Objects.isNull(customer)) {
            result.put("info", "该用户可以使用");
        } else {
            result.put("info", "该账号已存在");
        }
        return result;
    }


    @PostMapping("/doregister")
    public String doRegister(Customer customer, String yzm, HttpSession session, Model model) {
        String rdmCode = (String) session.getAttribute("rdmCode");
        if (!rdmCode.equals(yzm)) {
            model.addAttribute("error", "验证码输入错误");
            return "register";
        }

        customer.setCpass(MD5Util.getMd5Str(customer.getCpass()));
        customerServiceImpl.registerCustomer(customer);
        return "customerlogin";
    }

    @PostMapping("/customerlogin")
    public String doCustomerLogin(String cname, String cpass, HttpSession session, Model model, String yzm) {

        Customer customer = customerServiceImpl.login(cname, MD5Util.getMd5Str(cpass));

        if (Objects.isNull(customer)) {
            model.addAttribute("error", "账号或密码输入错误");
            return "customerlogin";
        }

        String rdmCode = (String) session.getAttribute("rdmCode");

        if (!rdmCode.equals(yzm)) {
            model.addAttribute("error", "验证码输入错误");
            return "customerlogin";
        }

        session.setAttribute("customer", customer);
        return "redirect:front/index";
    }

    @GetMapping("/customerlogout")
    public String doCustomerLogout(HttpSession session) {
        session.removeAttribute("customer");
        return "redirect:front/index";
    }
}
