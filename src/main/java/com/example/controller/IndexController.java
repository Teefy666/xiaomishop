package com.example.controller;

import com.example.entity.Product;
import com.example.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : TTF
 * @date : 2020/9/22
 */

@Controller
@RequestMapping("/front")
public class IndexController {

    @Resource
    ProductService productServiceImpl;

    @GetMapping("/index")
    public String toShopPage(Model model) {
        List<Product> list = productServiceImpl.getProductList();
        model.addAttribute("products", list);
        return "shop";
    }

}
