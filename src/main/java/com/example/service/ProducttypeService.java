package com.example.service;

import java.util.List;

import com.example.entity.PageBean;
import com.example.entity.Producttype;

public interface ProducttypeService {
    List<Producttype> selectProducttype();

    Producttype selectProducttypeById(Integer id);

    int insertProducttype(Producttype value);

    int deleteProducttypeById(Integer id);

    int updateProducttypeById(Producttype producttype);

    PageBean<Producttype> getProductTypeByPage(int page, int pageSize);
}