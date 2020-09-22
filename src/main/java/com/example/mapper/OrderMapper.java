package com.example.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface OrderMapper {
    List<HashMap<String, Object>> getOrderByPage(@Param("pageStart") int pageStart,
                                                 @Param("pageSize") int pageSize);
    int getRowCount();
}
