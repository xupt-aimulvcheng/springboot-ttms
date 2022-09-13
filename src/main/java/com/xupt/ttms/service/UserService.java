package com.xupt.ttms.service;

import com.xupt.ttms.pojo.User;

public interface UserService {
    User getUserByUsername(String username);

    User getUserByUsernameAndPwd(String username, String password);

    int register(User user);

    int updateUserByUsernameAndPhone(String username, String password, String phone);
}
