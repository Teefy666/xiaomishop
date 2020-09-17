package com.example.mapper;
import com.example.entity.Producttype;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProducttypeMapper{
    //查询全部
    List<Producttype> selectProducttype();
    //根据id查询
    Producttype selectProducttypeById(@Param("id") Integer id);
    //插入
    int insertProducttype(Producttype value);
    //删除
    int deleteProducttypeById(@Param("id") Integer id);
    //修改
    int updateProducttypeById(Producttype producttype);

    List<Producttype> getProductTypeByPage(@Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

    int selectRowCount();
}