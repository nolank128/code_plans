package com.project.smart_campus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.project.smart_campus.pojo.Admin;
import com.project.smart_campus.pojo.LoginForm;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/27/22:02
 */


/*
* 基本的增删改查
* */
public interface AdminService extends IService<Admin> {

    Admin login(LoginForm loginForm);

    //查询管理员表中账户
    Admin getAdminById(Long userId);

    //分页查询管理员账户
    IPage<Admin> getAdminsByOpr(Page<Admin> page, String adminName);
}
