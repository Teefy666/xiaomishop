package com.example.service.impl;

import com.example.entity.PageBean;
import com.example.mapper.ProductMapper;
import com.example.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author:TTF
 * @date:2020/9/15
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public List<HashMap<String, Object>> getProducts() {
        return productMapper.getProducts();
    }

    @Override
    public PageBean<HashMap<String, Object>> getProductByPage(int page, int pageSize, String name, int typeid) {
        List<HashMap<String, Object>> list = productMapper.getProductByPage((page - 1) * pageSize, pageSize, name, typeid);

        PageBean<HashMap<String, Object>> pageBean = new PageBean<>();
        //数据
        pageBean.setList(list);
        //页码
        pageBean.setPage(page);
        //记录总行数
        int rowCount = getTotalRowCount(name, typeid);
        //总页数
        pageBean.setPages((int) Math.ceil(rowCount*1.0/pageSize));
        return pageBean;
    }

    @Override
    public int delProductByiId(int id) {
        return productMapper.delProductById(id);
    }

    @Override
    public int delBatchProduct(int[] ids) {
        return productMapper.delBatchProduct(ids);
    }

    private int getTotalRowCount(String name, int typeid) {
        return productMapper.getRowCount(name, typeid);
    }
}
