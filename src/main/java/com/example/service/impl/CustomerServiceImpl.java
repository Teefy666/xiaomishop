package com.example.service.impl;

import com.example.entity.Customer;
import com.example.mapper.CustomerMapper;
import com.example.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : TTF
 * @date : 2020/9/22
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public Customer getCustomerByCname(String cname) {
        return customerMapper.getCustomerByCname(cname);
    }

    @Override
    public int registerCustomer(Customer customer) {
        return customerMapper.registerCustomer(customer);
    }

    @Override
    public Customer login(String cname, String cpass) {
        return customerMapper.login(cname, cpass);
    }
}
