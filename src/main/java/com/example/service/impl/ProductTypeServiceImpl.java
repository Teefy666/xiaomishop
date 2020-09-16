package com.example.service.impl;

import com.example.entity.Producttype;
import com.example.mapper.ProductTypeMapper;
import com.example.service.ProductTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : TTF
 * @date : 2020/9/16
 */
@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Resource
    private ProductTypeMapper productTypeMapper;

    @Override
    public List<Producttype> getAllProductType() {
        return productTypeMapper.getAllProductType();
    }
}
