package com.example.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author:TTF
 * @date:2020/9/15
 */
public interface ProductMapper {

    List<HashMap<String, Object>> getProducts();

    List<HashMap<String, Object>> getProductByPage(@Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

    int getRowCount();

    int delProductById(@Param("id") int id);
}
