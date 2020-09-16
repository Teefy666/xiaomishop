package com.example.controller;

import com.example.entity.PageBean;
import com.example.entity.Producttype;
import com.example.service.ProductService;
import com.example.service.ProducttypeService;
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
    private ProducttypeService producttypeServiceImpl;

    @GetMapping("/getProduct")
    public String getAllProducts(Model model) {
        List<HashMap<String, Object>> products = productServiceImpl.getProducts();
        model.addAttribute("products", products);
        return "productnopage";
    }

    /**
     * 分页查询
     * @param model
     * @param page
     * @return
     */
    @GetMapping("/getproductbypage")
    public String getProductsPage(Model model, @RequestParam(name = "page", defaultValue = "1") int page) {
        int pageSize = 5;
        PageBean<HashMap<String, Object>> pageBean = productServiceImpl.getProductByPage(page, pageSize);
        List<Producttype> list = producttypeServiceImpl.selectProducttype();
        model.addAttribute("ptlist", list);
        model.addAttribute("pagebean", pageBean);
        return "productbypage";
    }

    /**
     * 删除单条
     * @param id
     * @return
     */
    @GetMapping("/delproduct")
    public String delProductByid(int id) {
        productServiceImpl.delProductByiId(id);
        return "redirect:getproductbypage";
    }

    /**
     * 进入商品添加页面
     * @param model
     * @return
     */
    @GetMapping("/addproductpage")
    public String toAddProductPage(Model model) {
        List<Producttype> list = producttypeServiceImpl.selectProducttype();
        model.addAttribute("ptlist", list);
        return "addproduct";
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @GetMapping("/batchdelproduct")
    public String delBatchProduct(int[] ids) {
        productServiceImpl.delBatchProduct(ids);
        return "redirect:getproductbypage";
    }
}
