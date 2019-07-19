package com.xdmd.environment.user.Service.impl;

import com.xdmd.environment.user.Pojo.User;
import com.xdmd.environment.user.Service.UserService;
import com.xdmd.environment.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    User user = new User();

    public User userlogin(String username, String password) {
        user = userMapper.queryUser(username, password);
        return user;
    }
}
