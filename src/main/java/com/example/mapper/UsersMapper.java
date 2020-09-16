package com.example.mapper;

import com.example.entity.Users;

import java.util.HashMap;

/**
 * @author:TTF
 * @date:2020/9/15
 */
public interface UsersMapper {

    HashMap<String, Object> userLogin(Users user);
}
