package com.example.controller;

import com.example.entity.Product;
import com.example.entity.Producttype;
import com.example.service.ProducttypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author : TTF
 * @date : 2020/9/16
 */
@Controller
public class ProductTypeController {

    @Resource
    private ProducttypeService productServiceImpl;

    /**
     * 跳转到类型管理页面
     * @param model
     * @return
     */
    @RequestMapping("/toproducttypepage")
    public String getProductType(Model model) {
        model.addAttribute("producttypes", productServiceImpl.selectProducttype());
        return "producttypenoajax";
    }

    @RequestMapping("/addproducttypepage")
    public String toAddproducttypePage() {
        return "addproducttype";
    }

    @RequestMapping("/delproducttype")
    public String delProTypeById(int id) {
        productServiceImpl.deleteProducttypeById(id);
        return "redirect:/toproducttypepage";
    }

    @RequestMapping("/addprotype")
    public String addProType(Producttype pt) {
        productServiceImpl.insertProducttype(pt);
        return "redirect:/toproducttypepage";
    }
}
