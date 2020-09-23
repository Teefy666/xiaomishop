package com.example.controller;

import com.example.entity.Carshop;
import com.example.service.CarShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @author : TTF
 * @date : 2020/9/23
 */
@Controller
public class CarShopController {

    @Resource
    private CarShopService carShopServiceImpl;

    @GetMapping("/addcarshop")
    public String addCarShop(int customerid, int pid, int numbers) {
        carShopServiceImpl.addCarShop(customerid, pid, numbers);

        return "redirect:/showcarshopbycustomerid?customerid="+customerid;
    }

    @GetMapping("/showcarshopbycustomerid")
    public String showCarShop(int customerid, Model model) {
        List<HashMap<String, Object>> list = carShopServiceImpl.getCarShops(customerid);
        model.addAttribute("carlist", list);
        return "carshop";
    }

    // @GetMapping("/deletecarshop")
    // public String deleteCarShop(int customerid) {
    //
    // }
}
