package com.bob.dao.impl;

import com.bob.bean.Users;
import com.bob.dao.DBUtils;
import com.bob.dao.UsersDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


//继承工具类方便操作数据库，再实现接口
public class UsersDaoImpl extends DBUtils implements UsersDao {
    Users user = null;//一个空的容器
    @Override
    public Users login(String uname, String upass) {

        try {
            //操作数据库
            String sql = "select * from users where loginname=? and password=?";

            List params = new ArrayList();
            params.add(uname);
            params.add(upass);

            resultSet = query(sql, params);
            while(resultSet.next()){
                //如果结果集里有数据，那么才初始化一个Users对象给到原来的空容器
                 user = new Users();
                 //user.setLoginName(uname);调取各种set方法设置对象的字段值
                 user.setLoginName(resultSet.getString("loginname"));
                 user.setRealName(resultSet.getString("realname"));

                 user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }
        return user;
    }
}
