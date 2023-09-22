package com.project.smart_campus.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.smart_campus.pojo.Clazz;
import com.project.smart_campus.service.ClazzService;
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
 * @Date: 2023/07/27/22:39
 */
@Api(tags = "班级管理控制器")
@RestController //所以的都是异步交互
@RequestMapping("/sms/clazzController")   //请求路径
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    // /sms/clazzController/getClazzsByOpr/1/3?gradeName=?&name=?
    @ApiOperation("分页带条件查询班级信息")
    @GetMapping("/getClazzsByOpr/{pageNo}/{pageSize}")
    public Result getClazzsByOpr(
           @ApiParam("分页查询的页码数") @PathVariable("pageNo") Integer pageNo,
           @ApiParam("分页查询的页大小") @PathVariable("pageSize") Integer pageSize,
           @ApiParam("分页查询的查询条件") Clazz clazz

    ){

        Page<Clazz> page=new Page<>(pageNo,pageSize);
        IPage<Clazz> iPage=clazzService.getClazzByOpr(page,clazz);

        return Result.ok(iPage);
    }

    // /sms/clazzController/saveOrUpdateClazz

    @ApiOperation("新增或修改clazz,有id属性是修改,没有则是增加")
    @PostMapping("/saveOrUpdateClazz")
    public Result saveOrUpdateClazz(
            @ApiParam("JSon的格式的班级信息")@RequestBody Clazz clazz
    ){
        //调用服务层方法实现
        clazzService.saveOrUpdate(clazz);
        return Result.ok();

    }

    // /sms/clazzController/deleteClazz
    @ApiOperation("删除单个或者多个班级")
    @DeleteMapping("/deleteClazz")
    public Result deleteClazz(
            @ApiParam("要删除的多个班级的ID的JSON数组") @RequestBody List<Integer> ids
            ){
        clazzService.removeByIds(ids);

        return Result.ok();
    }


    //查询所有班级信息
    @ApiOperation("查询所有班级的信息")
    @GetMapping("/getClazzs")
    public Result getClazzs(){
        List<Clazz> clazzes=clazzService.getClazzs();
        return Result.ok(clazzes);
    }



}
