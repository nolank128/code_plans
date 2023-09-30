package com.bob.dao;

import com.bob.bean.Users;

public interface UsersDao {
    public Users login(String uname, String upass);
}
