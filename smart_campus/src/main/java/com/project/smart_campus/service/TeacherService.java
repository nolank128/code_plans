package com.project.smart_campus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.project.smart_campus.pojo.LoginForm;
import com.project.smart_campus.pojo.Teacher;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/27/22:12
 */
public interface TeacherService extends IService<Teacher> {
    Teacher login(LoginForm loginForm);

    Teacher getByTeacherById(Long userId);


//    /*分页查询操作*/
    IPage<Teacher> getTeachersByOpr(Page<Teacher> page, Teacher teacher);
}
