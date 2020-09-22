package com.example.service.impl;

import com.example.entity.PageBean;
import com.example.mapper.OrderMapper;
import com.example.service.OrderService;
import org.aspectj.weaver.patterns.HasThisTypePatternTriedToSneakInSomeGenericOrParameterizedTypePatternMatchingStuffAnywhereVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public PageBean<HashMap<String, Object>> getOrderByPage(int page,int pageSize) {
        List<HashMap<String, Object>> orderByPage = orderMapper.getOrderByPage(page*pageSize, pageSize);
        PageBean<HashMap<String, Object>> pageBean = new PageBean<>();
        //数据
        pageBean.setList(orderByPage);
        //页码
        pageBean.setPage(page+1);
        //记录总行数
        int rowCount = orderMapper.getRowCount();
        //总页数
        pageBean.setPages((int) Math.ceil(rowCount*1.0/pageSize));
        return pageBean;
    }
}
