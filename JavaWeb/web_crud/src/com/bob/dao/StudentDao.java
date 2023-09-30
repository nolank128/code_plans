package com.bob.dao;

import com.bob.bean.Student;

import java.util.List;

public interface StudentDao {
    //一行数据等价于一个对象，多行数据就是多个对象，显然这里我们查询到的肯定是多个对象
    public List<Student> getall(int pageIndex,int pageSize,String stuName,String stuNo,int sex);
    //计算总条数
    public int totalCount(String stuName,String stuNo,int sex);
    //新增学生
    public int insertStu(Student student);
    //根据ID删除学生
    public int del(String sid);
    //主键查询
    public Student findbyid(String sid);
    //修改
    public int updateStu(Student student);
}
