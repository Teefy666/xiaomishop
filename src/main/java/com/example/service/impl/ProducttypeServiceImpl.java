package com.example.service.impl;
import java.util.List;

import com.example.entity.Producttype;
import com.example.mapper.ProducttypeMapper;
import com.example.service.ProducttypeService;
import com.example.mapper.ProducttypeMapper;
import com.example.entity.Producttype;
import com.example.service.ProducttypeService;
import org.springframework.stereotype.Service;

@Service
public class ProducttypeServiceImpl implements ProducttypeService {
    private ProducttypeMapper producttypeMapper;
    @Override
    public long getProducttypeRowCount(){
        return producttypeMapper.getProducttypeRowCount();
    }
    @Override
    public List<Producttype> selectProducttype(){
        return producttypeMapper.selectProducttype();
    }
    @Override
    public Producttype selectProducttypeById(Integer id){
        return producttypeMapper.selectProducttypeById(id);
    }
    @Override
    public int insertProducttype(Producttype value){
        return producttypeMapper.insertProducttype(value);
    }
    @Override
    public int insertNonEmptyProducttype(Producttype value){
        return producttypeMapper.insertNonEmptyProducttype(value);
    }
    @Override
    public int deleteProducttypeById(Integer id){
        return producttypeMapper.deleteProducttypeById(id);
    }
    @Override
    public int updateProducttypeById(Producttype enti){
        return producttypeMapper.updateProducttypeById(enti);
    }
    @Override
    public int updateNonEmptyProducttypeById(Producttype enti){
        return producttypeMapper.updateNonEmptyProducttypeById(enti);
    }

    public ProducttypeMapper getProducttypeMapper() {
        return this.producttypeMapper;
    }

    public void setProducttypeMapper(ProducttypeMapper producttypeMapper) {
        this.producttypeMapper = producttypeMapper;
    }

}