package com.example.controller;

import com.example.entity.Producttype;
import com.example.service.ProducttypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;

/**
 * @author : TTF
 * @date : 2020/9/16
 */
@Controller
public class ProductTypeController {

    @Resource
    private ProducttypeService producttypeServiceImpl;

    /**
     * 跳转到类型管理页面
     * @param model
     * @return
     */
    @GetMapping("/toproducttypepage")
    public String getProductType(Model model) {
        model.addAttribute("producttypes", producttypeServiceImpl.selectProducttype());
        return "producttypenoajax";
    }

    @GetMapping("/addproducttypepage")
    public String toAddproducttypePage() {
        return "addproducttype";
    }

    // @GetMapping("/toupdateprotypepage")
    // public String toUpdateproducttypePage(int id) {
    //
    //     return "updateproducttype";
    // }

    @GetMapping("/delproducttype")
    public String delProTypeById(int id) {
        producttypeServiceImpl.deleteProducttypeById(id);
        return "redirect:/toproducttypepage";
    }

    @PostMapping("/addprotype")
    public String addProType(Producttype pt) {
        producttypeServiceImpl.insertProducttype(pt);
        return "redirect:/toproducttypepage";
    }

    // @PostMapping("/updateprotype")
    // public String updateProType(Producttype pt) {
    //     producttypeServiceImpl.insertProducttype(pt);
    //     return "redirect:/toproducttypepage";
    // }
}
