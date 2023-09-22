package com.project.smart_campus.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.smart_campus.pojo.Admin;
import com.project.smart_campus.service.AdminService;
import com.project.smart_campus.util.MD5;
import com.project.smart_campus.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/27/22:36
 */
@Api(tags = "管理员管理控制器")
@RestController //所以的都是异步交互
@RequestMapping("/sms/adminController")   //请求路径
public class AdminController {


    @Autowired
    private AdminService adminService;

    /*
    * /sms/adminController/getAllAdmin/1/3
    * 分页查询
    * */

    @ApiOperation("分页查询功能")
    @GetMapping("/getAllAdmin/{pageNo}/{pageSize}")
    public Result getAllAdmin(
            @ApiParam("页码") @PathVariable("pageNo") Integer pageNo,
            @ApiParam("页大小") @PathVariable("pageSize") Integer pageSize,
            @ApiParam("管理员名字") String adminName
    ){

        Page<Admin> page=new Page<>(pageNo,pageSize);
        IPage<Admin> iPage=adminService.getAdminsByOpr(page,adminName);
        return Result.ok(iPage);
    }


    /*
    * sms/adminController/saveOrUpdateAdmin
    * 增加或者修改管理员信息
    * */

    @ApiOperation("增加或者修改管理员信息")
    @PostMapping("/saveOrUpdateAdmin")
    public Result saveOrUpdateAdmin(
            @ApiParam("JSON格式的Admin对象") @RequestBody Admin admin
    ){
        Integer id=admin.getId();
        //如果是新增管理员，则对密码进行加密
        if (id==null|| id==0){
            admin.setPassword(MD5.encrypt(admin.getPassword()));
        }
        adminService.saveOrUpdate(admin);
        return Result.ok();

    }


    /*
    * 删除用户
    * /sms/adminController/deleteAdmin
    * */

    @ApiOperation("删除单个用户或者批量删除多个用户")
    @DeleteMapping("/deleteAdmin")
    public Result deleteAdmin(
            @ApiParam("删除管理员用户的id的JSON集合")@RequestBody List<Integer> ids
            ){
        adminService.removeByIds(ids);
        return Result.ok();
    }

}
