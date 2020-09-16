package com.example.controller;

import com.example.entity.PageBean;
import com.example.entity.Producttype;
import com.example.service.ProductService;
import com.example.service.ProductTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author : TTF
 * @date : 2020/9/15
 */
@Controller
public class ProductController {

    @Resource
    private ProductService productServiceImpl;

    @Resource
    private ProductTypeService productTypeServiceImpl;

    @GetMapping("/getProduct")
    public String getAllProducts(Model model) {
        List<HashMap<String, Object>> products = productServiceImpl.getProducts();
        model.addAttribute("products", products);
        return "productnopage";
    }

    @GetMapping("/getproductbypage")
    public String getProductsPage(Model model, @RequestParam(name = "page", defaultValue = "1") int page) {
        int pageSize = 5;
        PageBean<HashMap<String, Object>> pageBean = productServiceImpl.getProductByPage(page, pageSize);
        List<Producttype> list = productTypeServiceImpl.getAllProductType();
        model.addAttribute("ptlist", list);
        model.addAttribute("pagebean", pageBean);
        return "productbypage";
    }


    @GetMapping("/delproduct")
    public String delProductByid(int id) {
        productServiceImpl.delProductByiId(id);
        return "redirect:getproductbypage";
    }

    @GetMapping("/addproductpage")
    public String toAddProductPage(Model model) {
        List<Producttype> list = productTypeServiceImpl.getAllProductType();
        model.addAttribute("ptlist", list);
        return "addproduct";
    }
}
