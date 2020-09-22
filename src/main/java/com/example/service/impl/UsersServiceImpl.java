package com.example.service.impl;

import com.example.entity.PageBean;
import com.example.entity.Users;
import com.example.mapper.UsersMapper;
import com.example.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceClient;
import java.util.HashMap;

/**
 * @author:TTF
 * @date:2020/9/15
 */
@Service
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersMapper usersMapper;

    @Override
    public HashMap<String, Object> userLogin(Users users) {
        return usersMapper.userLogin(users);
    }

    @Override
    public PageBean<HashMap<String, Object>> getUsersByPage(int page, int pageSize, String uname, int roleid) {
        return null;
    }
}
