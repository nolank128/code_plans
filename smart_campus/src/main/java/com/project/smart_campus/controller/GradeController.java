package com.project.smart_campus.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.smart_campus.pojo.Grade;
import com.project.smart_campus.service.GradeService;
import com.project.smart_campus.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/27/22:40
 */
@Api(tags = "年级管理控制器")
@RestController //所以的都是异步交互
@RequestMapping("/sms/gradeController")   //请求路径
public class GradeController {

    @Autowired
    private GradeService gradeService;

    /*
    * 进入班级查询管理页面，先查询年级
    * */

    @ApiOperation("获取全部年级")
    @GetMapping("/getGrades")
    public Result getGrades(){

        List<Grade> grades=gradeService.getGrades();
        return Result.ok(grades);
    }



    /*
    *
    通过 @PathVariable 可以将URL中占位符参数{xxx}绑定到处理器类的方法形参中@PathVariable(“xxx“)
    * /getGrades/{pageNo}/{pageSize}
    * /getGrades/1/3
    *
    * /sms/gradeController/getGrades/1/3?gradeName=.....
    * */

    @ApiOperation("根据年级名称进行模糊查询，并进行分页")
    @GetMapping("/getGrades/{pageNo}/{pageSize}")
    public Result getGrades(
           @ApiParam("分页查询的页码数") @PathVariable("pageNo") Integer pageNo,
           @ApiParam("分页查询的页大小") @PathVariable("pageSize") Integer pageSize,
            //@RequestParam("gradeName") String gradeName //找到所对应的参数
           @ApiParam("分页查询的模糊匹配的名称") String gradeName
    ){

        //分页  带条件查询
        Page<Grade> page=new Page<>(pageNo,pageSize);
        //通过服务层实现
        //分页查询条件，查询对应参数

        IPage<Grade> iPage=gradeService.getGradeByOpr(page,gradeName);
        return Result.ok(page);
    }



    /*
    * 添加操作
    * */

    @ApiOperation("添加或修改年级信息，有id属性为修改，无id则为添加")
    @PostMapping("/saveOrUpdateGrade")
    public Result saveOrUpdateGrade(
            @ApiParam("Json格式的Grade对象")@RequestBody Grade grade
    ){
        //输出添加操作参数用于接受,调用方法用于完成修改操作
        gradeService.saveOrUpdate(grade);
        return Result.ok();
    }


    /*
    * 删除操作
    * */
    @ApiOperation("删除或者批量删除Grade信息")
    @DeleteMapping("/deleteGrade")
    public Result deleteGrade(
            @ApiParam("删除Grade的id的集合") @RequestBody List<Integer> ids){
        //接受参数，以集合方式 接受传入参数，记录删除或批量删除的参数
        gradeService.removeByIds(ids);
        return Result.ok();
    }


}
