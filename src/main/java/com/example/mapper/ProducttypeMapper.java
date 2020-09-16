package com.example.mapper;
import com.example.entity.Producttype;

import java.util.List;
public interface ProducttypeMapper{
    long getProducttypeRowCount();
    List<Producttype> selectProducttype();
    Producttype selectProducttypeById(Integer id);
    int insertProducttype(Producttype value);
    int insertNonEmptyProducttype(Producttype value);
    int deleteProducttypeById(Integer id);
    int updateProducttypeById(Producttype enti);
    int updateNonEmptyProducttypeById(Producttype enti);
}