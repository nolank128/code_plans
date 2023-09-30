package com.bob.service.impl;

import com.bob.bean.Student;
import com.bob.dao.StudentDao;
import com.bob.dao.impl.StudentDaoImpl;
import com.bob.service.StudentService;

import java.sql.SQLException;
import java.util.List;
//业务逻辑层，主要编写业务逻辑
public class StudentServiceImpl implements StudentService {
    StudentDao studentDao = new StudentDaoImpl();

    @Override
    public List<Student> getall() throws SQLException {
        return studentDao.getall();
    }
}
