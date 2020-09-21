package com.example.service;

import com.example.entity.PageBean;
import com.example.entity.Users;

import java.util.HashMap;

/**
 * @author:TTF
 * @date:2020/9/15
 */
public interface UsersService {

    HashMap<String, Object> userLogin(Users users);

    PageBean<HashMap<String, Object>> getUsersByPage(int page, int pageSize, String uname, int roleid);
}
