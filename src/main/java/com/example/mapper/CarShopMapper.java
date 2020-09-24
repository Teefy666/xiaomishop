package com.example.mapper;

import com.example.entity.Carshop;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author : TTF
 * @date : 2020/9/23
 */
public interface CarShopMapper {
    int addCarShop(@Param("customerid") int customerid,
                   @Param("pid") int pid,
                   @Param("numbers") int numbers);

    List<HashMap<String, Object>> getCarShops(@Param("customerid") int customerid);

    Carshop getCarShopByIdAndPid(@Param("customerid") int customerid, @Param("pid") int pid);

    int updateCarShop(@Param("customerid") int customerid,
                      @Param("pid") int pid,
                      @Param("numbers") int numbers);

    int deleteCarShop(@Param("cid") int cid);

    int updateNumbers(@Param("cid") int cid, @Param("num") int num);
}
