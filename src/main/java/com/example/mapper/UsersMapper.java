package com.example.mapper;

import com.example.entity.Role;
import com.example.entity.Users;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author:TTF
 * @date:2020/9/15
 */
public interface UsersMapper {

    HashMap<String, Object> userLogin(Users user);

    List<HashMap<String, Object>> getUsersByPage(@Param("pageStart") int pageStart,
                                                 @Param("pageSize") int pageSize,
                                                 @Param("uname") String uname,
                                                 @Param("roleid") int roleid);

    int getRowCount(@Param("uname") String uname, @Param("roleid") int roleid);

    List<Role> getRoleList();

    int delUsers(@Param("id") int id);

    int batchDelUsers(@Param("ids") int[] ids);

    Users getUserById(@Param("id") int id);

    int addUser(Users users);

    int updateUser(Users users);
}
