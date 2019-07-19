package com.xdmd.environment.user.Service;

import com.xdmd.environment.user.Pojo.User;

public interface UserService {
    User userlogin(String username, String password);
}
