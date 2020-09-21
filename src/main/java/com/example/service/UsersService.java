package com.example.service;

import com.example.entity.PageBean;
import com.example.entity.Role;
import com.example.entity.Users;

import java.util.HashMap;
import java.util.List;

/**
 * @author:TTF
 * @date:2020/9/15
 */
public interface UsersService {

    HashMap<String, Object> userLogin(Users users);

    PageBean<HashMap<String, Object>> getUsersByPage(int page, int pageSize, String uname, int roleid);

    List<Role> getRoleList();

    int delUsers(int id);

    int batchDelUsers(int[] ids);


    Users getUserById(int id);

    int addUser(Users users);

    int updateUser(Users users);
}
