package com.bob.service.impl;

import com.bob.bean.Student;
import com.bob.dao.StudentDao;
import com.bob.dao.impl.StudentDaoImpl;
import com.bob.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();
    @Override
    public List<Student> getall(int pageIndex,int pageSize,String stuName,String stuNo,int sex) {
        return studentDao.getall(pageIndex,pageSize,stuName,stuNo,sex);
    }

    @Override
    public int totalCount(String stuName,String stuNo,int sex) {
        return studentDao.totalCount(stuName, stuNo, sex);
    }

    @Override
    public int insertStu(Student student) {
        return studentDao.insertStu(student);
    }

    @Override
    public int del(String sid) {
        return studentDao.del(sid);
    }

    @Override
    public Student findbyid(String sid) {
        return studentDao.findbyid(sid);
    }

    @Override
    public int updateStu(Student student) {
        return studentDao.updateStu(student);
    }

}
