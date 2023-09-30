package com.bob.service;

import com.bob.bean.Student;

import java.sql.SQLException;
import java.util.List;

//方法基本和dao层一样
public interface StudentService {
    //查询全部  一行数据等于一个Javabean对象
    public List<Student> getall() throws SQLException;
}
