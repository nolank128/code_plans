package com.project.smart_campus.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.smart_campus.pojo.Teacher;
import com.project.smart_campus.service.TeacherService;
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
 * @Date: 2023/07/27/22:41
 */
@Api(tags = "老师管理控制器")
@RestController //所以的都是异步交互
@RequestMapping("/sms/teacherController")   //请求路径
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    /*
    * 分页查询操作
    * sms/teacherController/getTeachers/1/3?name=？&clazzName=？
    * */
    @ApiOperation("分页查询操作")
    @GetMapping("/getTeachers/{pageNo}/{pageSize}")
    public Result getTeachers(
        @ApiParam("页码") @PathVariable("pageNo") Integer pageNo,
        @ApiParam("页大小")@PathVariable("pageSize") Integer pageSize,
        @ApiParam("查询条件") Teacher teacher
    ){
        Page<Teacher> page=new Page<>(pageNo,pageSize);

        IPage<Teacher> iPage=teacherService.getTeachersByOpr(page,teacher);
        return Result.ok(iPage);

    }


    /*
    * 修改或者添加教师信息
    * post sms/teacherController/saveOrUpdateTeacher
    * */

    @ApiOperation("添加或者修改教师信息")
    @PostMapping("/saveOrUpdateTeacher")
    public Result saveOrUpdateTeacher(
            @ApiParam("JOSN格式的Teacher") @RequestBody Teacher teacher
    ){
        Integer id=teacher.getId();
        // 如果是新增,要对密码进行加密
        if (id ==null ||id ==0){
            teacher.setPassword(MD5.encrypt(teacher.getPassword()));
        }
        teacherService.saveOrUpdate(teacher);
        return  Result.ok();
    }


    /*
    * 删除或者批量删除信息
    DELETE sms/teacherController/deleteTeacher
    */

    @ApiOperation("删除或者批量删除教师信息")
    @DeleteMapping("/deleteTeacher")
    public Result deleteTeacher(
            @ApiParam("JSON格式的教师信息")@RequestBody List<Integer> ids
            ){
        teacherService.removeByIds(ids);
        return Result.ok();
    }

}
