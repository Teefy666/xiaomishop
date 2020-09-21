package com.example.controller;

import com.example.entity.PageBean;
import com.example.entity.Producttype;
import com.example.service.ProducttypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;

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

    @GetMapping("/toupdateprotypepage")
    public String toUpdateproducttypePage(int id, Model model) {
        model.addAttribute("producttype", producttypeServiceImpl.selectProducttypeById(id));
        return "updateproducttype";
    }

    @GetMapping("/delproducttype")
    public String delProTypeById(int id) {
        producttypeServiceImpl.deleteProducttypeById(id);
        return "forward:/WEB-INF/jsp/producttype.jsp";
    }

    @PostMapping("/addprotype")
    public String addProType(Producttype pt) {
        producttypeServiceImpl.insertProducttype(pt);
        return "forward:/WEB-INF/jsp/producttype.jsp";
    }

    @PostMapping("/updateprotype")
    public String updateProType(Producttype pt) {
        producttypeServiceImpl.updateProducttypeById(pt);
        return "forward:/WEB-INF/jsp/producttype.jsp";
    }

    // @GetMapping("/getproducttypebypage")
    // public String getProducttypeByPage(Model model, @RequestParam(name = "page", defaultValue = "1") int page,
    //                                    @RequestParam(name = "typename", defaultValue = "") String typename) {
    //     int pageSize = 5;
    //     PageBean<Producttype> pagebean = producttypeServiceImpl.getProductTypeByPage(page, pageSize, typeId, typename);
    //     model.addAttribute("pagebean", pagebean);
    //     model.addAttribute("typename", typename);
    //     return "producttypenoajax";
    //
    // }

    @GetMapping("/toajaxpage")
    public String toPage() {
        return "producttype";
    }

    @ResponseBody
    @PostMapping("/producttypelistajax")
    public HashMap<String, Object> getAjaxPageData(int currentPage, int typeId, String typeName) {
        HashMap<String, Object> data = new HashMap<>();
        int pageSize = 5;

        PageBean<Producttype> pagebean = producttypeServiceImpl.getProductTypeByPage(currentPage, pageSize, typeId, typeName);
        data.put("list", pagebean.getList());
        data.put("pageSize", pageSize);
        data.put("pageCount", pagebean.getPages());
        data.put("rowCount", pagebean.getRowcount());
        return data;
    }

}
