package com.project.smart_campus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.smart_campus.mapper.AdminMapper;
import com.project.smart_campus.pojo.Admin;
import com.project.smart_campus.pojo.LoginForm;
import com.project.smart_campus.service.AdminService;
import com.project.smart_campus.util.MD5;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/27/22:05
 */

@Service("adminServiceImpl")
@Transactional //事务控制
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Override
    public Admin login(LoginForm loginForm){
        QueryWrapper<Admin> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("name",loginForm.getUsername());
        queryWrapper.eq("password", MD5.encrypt(loginForm.getPassword()));

        Admin admin=baseMapper.selectOne(queryWrapper);
        return admin;
    }

    @Override
    public Admin getAdminById(Long userId) {
        QueryWrapper<Admin> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",userId);

        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public IPage<Admin> getAdminsByOpr(Page<Admin> page, String adminName) {

        QueryWrapper<Admin> queryWrapper=new QueryWrapper<>();
        if (!StringUtils.isEmpty(adminName)){
            queryWrapper.like("name",adminName);
        }
        queryWrapper.orderByDesc("id");

        Page<Admin> page1=baseMapper.selectPage(page,queryWrapper);

        return page1;
    }
}
