package com.example.service;

import com.example.entity.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author:TTF
 * @date:2020/9/15
 */
public interface ProductService {

    List<HashMap<String, Object>> getProducts();


    PageBean<HashMap<String, Object>> getProductByPage(int page, int pageSize);

    int delProductByiId(int id);

    int delBatchProduct(int[] ids);
}
