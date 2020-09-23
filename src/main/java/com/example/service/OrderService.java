package com.example.service;

import com.example.entity.PageBean;

import java.util.HashMap;

/**
 * MQ
 */
public interface OrderService {
    PageBean<HashMap<String, Object>> getOrderByPage(int pageStart,int pageSize);
}
