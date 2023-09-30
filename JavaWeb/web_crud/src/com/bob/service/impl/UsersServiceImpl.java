package com.bob.service.impl;

import com.bob.bean.Users;
import com.bob.dao.UsersDao;
import com.bob.dao.impl.UsersDaoImpl;
import com.bob.service.UsersService;

//service层本阶段主要用来直接调取dao层
public class UsersServiceImpl implements UsersService {
    private UsersDao usersDao= new UsersDaoImpl();//体现多态，声明接口new实现类
    @Override
    public Users login(String uname, String upass) {
        return usersDao.login(uname,upass);
    }
}
