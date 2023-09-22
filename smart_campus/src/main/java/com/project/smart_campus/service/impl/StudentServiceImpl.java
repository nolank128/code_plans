package com.project.smart_campus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.smart_campus.mapper.StudentMapper;
import com.project.smart_campus.pojo.LoginForm;
import com.project.smart_campus.pojo.Student;
import com.project.smart_campus.service.StudentService;
import com.project.smart_campus.util.MD5;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/27/22:16
 */
@Service("studentServiceImpl")
@Transactional //事务控制
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Override
    public Student login(LoginForm loginForm) {
        QueryWrapper<Student> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("name",loginForm.getUsername());
        queryWrapper.eq("password", MD5.encrypt(loginForm.getPassword()));
        Student student=baseMapper.selectOne(queryWrapper);
        return student;
    }

    @Override
    public Student getStudentById(Long userId) {
        QueryWrapper<Student> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",userId);
        return baseMapper.selectOne(queryWrapper);
    }


    /*
    * 分页带条件查询学生信息
    * */
    @Override
    public IPage<Student> getStudentByopr(Page<Student> page, Student student) {
        QueryWrapper<Student> queryWrapper=new QueryWrapper<>();
        if (!StringUtils.isEmpty(student.getName())){
            queryWrapper.like("name",student.getName());
        }
        if (!StringUtils.isEmpty(student.getClazzName())){
            queryWrapper.like("clazz_name",student.getClazzName());
        }
        queryWrapper.orderByDesc("id");
        Page<Student> studentPage=baseMapper.selectPage(page,queryWrapper);
        return studentPage;
    }





}
