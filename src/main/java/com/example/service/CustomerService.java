package com.example.service;

import com.example.entity.Customer;

/**
 * @author : TTF
 * @date : 2020/9/22
 */
public interface CustomerService {
    Customer getCustomerByCname(String cname);

    int registerCustomer(Customer customer);

    Customer login(String cname, String cpass);
}
