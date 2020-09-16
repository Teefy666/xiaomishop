package com.example.service.impl;

import java.util.List;

import com.example.entity.Producttype;
import com.example.mapper.ProducttypeMapper;
import com.example.service.ProducttypeService;
import com.example.mapper.ProducttypeMapper;
import com.example.entity.Producttype;
import com.example.service.ProducttypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProducttypeServiceImpl implements ProducttypeService {
    @Resource
    private ProducttypeMapper producttypeMapper;

    @Override
    public List<Producttype> selectProducttype() {
        return producttypeMapper.selectProducttype();
    }

    @Override
    public Producttype selectProducttypeById(Integer id) {
        return producttypeMapper.selectProducttypeById(id);
    }

    @Override
    public int insertProducttype(Producttype value) {
        return producttypeMapper.insertProducttype(value);
    }

    @Override
    public int deleteProducttypeById(Integer id) {
        return producttypeMapper.deleteProducttypeById(id);
    }

    @Override
    public int updateProducttypeById(Producttype producttype) {
        return producttypeMapper.updateProducttypeById(producttype);
    }
}