package com.example.service.impl;

import com.example.entity.Carshop;
import com.example.mapper.CarShopMapper;
import com.example.service.CarShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @author : TTF
 * @date : 2020/9/23
 */
@Service
public class CarShopServiceImpl implements CarShopService {

    @Resource
    private CarShopMapper carShopMapper;

    @Override
    public int addCarShop(int customerid, int pid, int numbers) {
        Carshop carshop = carShopMapper.getCarShopByIdAndPid(customerid, pid);
        if (Objects.isNull(carshop)) {
            carShopMapper.addCarShop(customerid, pid, numbers);
        } else {
            carShopMapper.updateCarShop(customerid, pid, carshop.getNumbers()+numbers);
        }
        return 1;
    }

    @Override
    public List<HashMap<String, Object>> getCarShops(int customerid) {
        return carShopMapper.getCarShops(customerid);
    }


}
