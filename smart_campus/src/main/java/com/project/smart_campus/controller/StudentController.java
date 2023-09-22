package com.project.smart_campus.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.smart_campus.pojo.Student;
import com.project.smart_campus.service.StudentService;
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
 * @Date: 2023/07/27/22:40
 */
@Api(tags = "学生管理控制器")
@RestController //所以的都是异步交互
@RequestMapping("/sms/studentController")   //请求路径
public class StudentController {

    @Autowired
    private StudentService studentService;

    /*
    * 分页查询和搜索
    * /sms/studentController/getStudentByOpr/1/3?name=a&clazzName=?
    * */


    @ApiOperation("分页带条件查询学生信息")
    @GetMapping("/getStudentByOpr/{pageNo}/{pageSize}")
    public Result getStudentByOpr(
            @ApiParam("pageNo") @PathVariable Integer pageNo,
            @ApiParam("pageSize")@PathVariable Integer pageSize,
            @ApiParam("分页查询的查询条件") Student student
    ){

        Page<Student> page=new Page<>(pageNo,pageSize);
        IPage<Student> iPage=studentService.getStudentByopr(page,student);

        return Result.ok(iPage);
    }


    /*
    * 增加和修改操作
    * sms/studentController/addOrUpdateStudent
    *
    * 修改没有修改学生密码操作
    * 增加有，而且是明文形式传入
    * */

    @ApiOperation("增加或者修改学生信息")
    @PostMapping("/addOrUpdateStudent")
    public Result addOrUpdateStudent(
            @ApiParam("Json格式的学生信息") @RequestBody Student student
    ){
        //判断null ==id 那么即判断该操作为增加操作
        Integer id=student.getId();
        if (null==id ||0==id){
            //对学生密码进行加密
            student.setPassword(MD5.encrypt(student.getPassword()));
        }
        studentService.saveOrUpdate(student);
        return Result.ok();

    }


    /*
    * 学生删除操作
    * /sms/studentController/delStudentById
    * */

    @ApiOperation("删除学生或批量删除学生")
    @DeleteMapping("/delStudentById")
    public Result delStudentById(
            @ApiParam ("学生编号的JSON数组") @RequestBody List<Integer> ids
    ){
        studentService.removeByIds(ids);
        return  Result.ok();
    }

}
