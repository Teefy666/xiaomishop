package com.example.service.impl;

import com.example.entity.PageBean;
import com.example.entity.Role;
import com.example.entity.Users;
import com.example.mapper.UsersMapper;
import com.example.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceClient;
import java.util.HashMap;
import java.util.List;

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
        List<HashMap<String, Object>> list = usersMapper.getUsersByPage((page - 1) * pageSize, pageSize, uname, roleid);

        PageBean<HashMap<String, Object>> pageBean = new PageBean<>();
        //数据
        pageBean.setList(list);
        //页码
        pageBean.setPage(page);
        //记录总行数
        int rowCount = getTotalRowCount(uname, roleid);
        //总页数
        pageBean.setPages((int) Math.ceil(rowCount*1.0/pageSize));
        return pageBean;
    }

    @Override
    public List<Role> getRoleList() {
        return usersMapper.getRoleList();
    }

    @Override
    public int delUsers(int id) {
        return usersMapper.delUsers(id);
    }

    @Override
    public int batchDelUsers(int[] ids) {
        return usersMapper.batchDelUsers(ids);
    }

    @Override
    public Users getUserById(int id) {
        return usersMapper.getUserById(id);
    }

    @Override
    public int addUser(Users users) {
        return usersMapper.addUser(users);
    }

    @Override
    public int updateUser(Users users) {
        return usersMapper.updateUser(users);
    }

    private int getTotalRowCount(String name, int roleid) {
        return usersMapper.getRowCount(name, roleid);
    }
}
