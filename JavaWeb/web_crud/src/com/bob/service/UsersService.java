package com.bob.service;

import com.bob.bean.Users;

public interface UsersService {
    //登录方法
    // sql select * from users where loginname = ? and password = ?
    public Users login(String uname, String upass);
}
