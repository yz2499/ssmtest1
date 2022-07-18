package com.yz.service.impl;


import com.yz.mapper.UserMapper;
import com.yz.pojo.User;
import com.yz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    //一定会有数据访问层的对象
    @Autowired
    UserMapper userMapper;


    @Override
    public List<User> selectUserPage(String userName, String userSex, int startRow) {
        return  userMapper.selectUserPage(userName,userSex,startRow);
    }

    @Override
    public int deleteUserById(String userId) {
        return userMapper.deleteUserById(userId);
    }

    @Override
    public int createUser(User user) {
        return userMapper.createUser(user);
    }

    @Override
    public int getRowCount(String userName, String userSex) {
        return userMapper.getRowCount(userName,userSex);
    }
}
