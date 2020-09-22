package com.example.controller;

import com.example.entity.PageBean;
import com.example.entity.Product;
import com.example.entity.Producttype;
import com.example.service.ProductService;
import com.example.service.ProducttypeService;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author MQ
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
     *
     * @param model
     * @param page
     * @return
     */
    @GetMapping("/getproductbypage")
    public String getProductsPage(Model model,
                                  @RequestParam(name = "page", defaultValue = "1") int page,
                                  @RequestParam(name = "name", defaultValue = "") String name,
                                  @RequestParam(name = "typeid", defaultValue = "-1") int typeid) {
        int pageSize = 5;
        PageBean<HashMap<String, Object>> pageBean = productServiceImpl.getProductByPage(page, pageSize, name, typeid);
        List<Producttype> list = producttypeServiceImpl.selectProducttype();
        model.addAttribute("ptlist", list);
        model.addAttribute("pagebean", pageBean);
        model.addAttribute("name", name);
        model.addAttribute("typeid", typeid);
        return "productbypage";
    }

    /**
     * 删除单条
     *
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
     *
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
     *
     * @param ids
     * @return
     */
    @GetMapping("/batchdelproduct")
    public String delBatchProduct(int[] ids) {
        productServiceImpl.delBatchProduct(ids);
        return "redirect:getproductbypage";
    }

    @PostMapping("/produpload")
    @ResponseBody
    public Map<String, String> uploadFile(MultipartFile upimage, HttpServletRequest request) {
        //获取文件名称
        String fileName = upimage.getOriginalFilename();
        String ext = fileName.substring(fileName.indexOf("."));
        //上传文件的名称
        String realName = UUID.randomUUID().toString() + ext;
        //服务器路径
        String serverPath = request.getServletContext().getRealPath("/") + "/resources/image_big/";
        Map<String, String> result = new HashMap<>();
        File file = new File(serverPath + realName);
        try {
            upimage.transferTo(file);
            result.put("imgurl", request.getContextPath() + "/resources/image_big/" + realName);
            result.put("imgName", realName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result.toString());
        return result;
    }

    @PostMapping("/addproduct")
    public String addPro(Product product) {
        product.setDate(new Date());
        productServiceImpl.addProduct(product);
        return "redirect:/getproductbypage";
    }

    @GetMapping("/getproductbyid")
    public String getProduct(int id, Model model) {
        Product product = productServiceImpl.getProductById(id);
        model.addAttribute("product", product);
        List<Producttype> producttypes = producttypeServiceImpl.selectProducttype();
        model.addAttribute("ptlist", producttypes);
        return "updateproduct";
    }

    @PostMapping("/updateproduct")
    public String updateProduct(Product product) {
        Product productById = productServiceImpl.getProductById(product.getId());
        if (product.getImage() == "") {
            product.setImage(productById.getImage());
        }
        if (product.getDate() == null) {
            product.setDate(productById.getDate());
        }
        productServiceImpl.updateProduct(product);
        return "redirect:/getproductbypage";
    }

    @GetMapping("/getproductdetail")
    public String getProductDetail(int id, Model model) {
        Product product = productServiceImpl.getProductById(id);
        model.addAttribute("product", product);
        return "productdetail";
    }
}
