package com.bob.dao;

import com.bob.bean.Student;

import java.sql.SQLException;
import java.util.List;

//定义操作数据库的方法
public interface StudentDao {
    //查询全部  一行数据等于一个Javabean对象
    public List<Student> getall() throws SQLException;
}
