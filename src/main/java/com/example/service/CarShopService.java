package com.example.service;

import com.example.entity.Carshop;

import java.util.HashMap;
import java.util.List;

/**
 * @author : TTF
 * @date : 2020/9/23
 */
public interface CarShopService {
    int addCarShop(int customerid, int pid, int numbers);

    List<HashMap<String, Object>> getCarShops(int customerid);

    int deleteCarShop(int cid);

    int updateNumbers(int cid, int num);
}
