package com.example.controller;

import com.example.entity.PageBean;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/getorderbypage")
    public String getOrderbypage(Model model, @RequestParam(name = "page", defaultValue = "1") int page) {
        int pageSize = 5;
        PageBean<HashMap<String, Object>> pageBean = orderService.getOrderByPage(page-1,pageSize);
        System.out.println(pageBean.toString());
        model.addAttribute("pagebean", pageBean);
        return "orderbypage";
    }
}
