package com.example.service.impl;

import java.util.List;

import com.example.entity.PageBean;
import com.example.entity.Producttype;
import com.example.mapper.ProducttypeMapper;
import com.example.service.ProducttypeService;
import org.apache.ibatis.annotations.Param;
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

    @Override
    public PageBean<Producttype> getProductTypeByPage(int page, int pageSize, int typeId, String typename) {
        List<Producttype> list =  producttypeMapper.getProductTypeByPage((page-1)*pageSize, pageSize, typeId, typename);
        PageBean<Producttype> pageBean = new PageBean<>();
        //数据
        pageBean.setList(list);
        //页码
        pageBean.setPage(page);
        //记录总行数
        int rowCount = selectTotalRowCount(typeId, typename);
        pageBean.setRowcount(rowCount);
        //总页数
        pageBean.setPages((int) Math.ceil(rowCount*1.0/pageSize));
        return pageBean;
    }

    private int selectTotalRowCount(int typeId, String typename) {
        return producttypeMapper.selectRowCount(typeId, typename);
    }


}