package com.example.mapper;

import com.example.entity.Customer;
import org.apache.ibatis.annotations.Param;

/**
 * @author : TTF
 * @date : 2020/9/22
 */
public interface CustomerMapper {
    Customer getCustomerByCname(@Param("cname") String cname);

    int registerCustomer(Customer customer);

    Customer login(@Param("cname") String cname, @Param("cpass") String cpass);
}
