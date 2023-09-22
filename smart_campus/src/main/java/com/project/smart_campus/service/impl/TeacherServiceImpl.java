package com.project.smart_campus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.smart_campus.mapper.TeacherMapper;
import com.project.smart_campus.pojo.LoginForm;
import com.project.smart_campus.pojo.Teacher;
import com.project.smart_campus.service.TeacherService;
import com.project.smart_campus.util.MD5;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/27/22:17
 */

@Service("teacherServiceImpl")
@Transactional //事务控制
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Override
    public Teacher getByTeacherById(Long userId) {
        QueryWrapper<Teacher> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",userId);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public Teacher login(LoginForm loginForm) {
        QueryWrapper<Teacher> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("name",loginForm.getUsername());
        queryWrapper.eq("password", MD5.encrypt(loginForm.getPassword()));
        Teacher teacher= baseMapper.selectOne(queryWrapper);

        return teacher;
    }

    @Override
    public IPage<Teacher> getTeachersByOpr(Page<Teacher> page, Teacher teacher) {

        QueryWrapper<Teacher> queryWrapper=new QueryWrapper<>();
        if (!StringUtils.isEmpty(teacher.getName())){
            queryWrapper.like("name",teacher.getName());
        }
        if (!StringUtils.isEmpty(teacher.getClazzName())){
            queryWrapper.eq("clazz_name",teacher.getClazzName());
        }

        queryWrapper.orderByDesc("id");
        Page<Teacher> page1=baseMapper.selectPage(page,queryWrapper);
        return page1;
    }
}
