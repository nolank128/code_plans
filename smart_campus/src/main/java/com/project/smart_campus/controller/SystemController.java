package com.project.smart_campus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.project.smart_campus.pojo.Admin;
import com.project.smart_campus.pojo.LoginForm;
import com.project.smart_campus.pojo.Student;
import com.project.smart_campus.pojo.Teacher;
import com.project.smart_campus.service.AdminService;
import com.project.smart_campus.service.StudentService;
import com.project.smart_campus.service.TeacherService;
import com.project.smart_campus.util.*;
import io.jsonwebtoken.JwtHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/27/22:42
 */


/*
* 公共请求资源
* */

@Api(tags = "系统管理控制器")
@RestController //所以的都是异步交互
@RequestMapping("/sms/system")   //请求路径
public class SystemController {



    @Autowired
    private AdminService adminService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;


    /*
    POST
    * sms/system/updatePwd/123456/12345678
    全局修改密码
    旧密码和新密码
    通过token进行身份校验
    * */


    @ApiOperation("全局密码更新器")
    @PostMapping("/updatePwd/{oldPwd}/{newPwd}")
    public Result updatePwd(
           @ApiParam("token口令") @RequestHeader("token") String token,
           @ApiParam("旧密码") @PathVariable("oldPwd") String oldPwd,
           @ApiParam("新密码") @PathVariable("newPwd") String newPwd
    ){
        boolean  expiration=JwtHelper.isExpiration(token);
        if (expiration){
            //token 过期
            return Result.fail().message("token过期，请重新登录");
        }
        //获取用户id和用户类型
        Long userId=JwtHelper.getUserId(token);
        Integer userType=JwtHelper.getUserType(token);

        //判断用户类型，管理员，教室，学生等
        switch (userType){
            case 1:
                QueryWrapper<Admin> queryWrapper=new QueryWrapper<>();
                queryWrapper.eq("id",userId.intValue());
                queryWrapper.eq("password", MD5.encrypt(oldPwd));
                Admin admin=adminService.getOne(queryWrapper);
                //验证了用户
                if (admin!=null){
                    //修改
                    admin.setPassword(MD5.encrypt(newPwd));
                    adminService.saveOrUpdate(admin);
                    //return Result.ok().message("密码修改成功");
                }else {
                    return Result.fail().message("原密码有误！");
                }
                break;

            case 2:
                QueryWrapper<Student> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.eq("id",userId.intValue());
                queryWrapper1.eq("password",MD5.encrypt(oldPwd));
                Student student=studentService.getOne(queryWrapper1);
                if (student!=null){
                    student.setPassword(MD5.encrypt(newPwd));
                    studentService.saveOrUpdate(student);
                    //return Result.ok().message("密码修改成功");
                }else {
                    return Result.fail().message("原密码有误！");
                }
                break;

            case 3:
                QueryWrapper<Teacher> queryWrapper2=new QueryWrapper<>();
                queryWrapper2.eq("id",userId.intValue());
                queryWrapper2.eq("password",MD5.encrypt(oldPwd));
                Teacher teacher=teacherService.getOne(queryWrapper2);
                if (teacher!=null){
                    teacher.setPassword(MD5.encrypt(newPwd));
                    teacherService.saveOrUpdate(teacher);
                    //return Result.ok().message("密码修改成功");
                }else {
                    return Result.fail().message("原密码有误！");
                }
                break;

        }
        return Result.ok();
    }






    //    sms/system/headerImgUpload
    @ApiOperation("文件上传统一入口")
    @PostMapping("/headerImgUpload")
    public Result headerImgUpload(
            //将图片抽象为一个MultipartFile对象
            @ApiParam("头像文件")@RequestPart("multipartFile") MultipartFile multipartFile,
            HttpServletRequest request
    ){
        //避免上传文件名一致，
        String uuid=UUID.randomUUID().toString().replace("-","").toLowerCase();
        //获取原始的文件名
        String originalFilename=multipartFile.getOriginalFilename();
        //找到最后一次.的位置
        int i=originalFilename.lastIndexOf(".");
        //截取后面的字符串
        String s=originalFilename.substring(i);
        //新文件名
        String newFileName=uuid+s;

        //保存文件 将文件发送到第三方或者独立的图片服务器，图层
        // springboot 内置的tomcat 所以填的路径其实不太对
        String portraitPath="D:/ideaProjects/smart_campus/target/classes/public/upload/".concat(newFileName);

        //将图片传入到上面的路径
        try {
            multipartFile.transferTo(new File(portraitPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //响应文件路径
        String path="upload/"+newFileName;
        return Result.ok(path);
    }






    /*
    * token 判断登录
    * */
    @ApiOperation("通过taken口令来获取当前登录的用户信息的方法")
    @GetMapping("/getInfo")
    public Result getInfoByToken(
            //请求头 token
            @ApiParam("token口令") @RequestHeader("token") String token){
        boolean expiration=JwtHelper.isExpiration(token);//验证token是否过期。
        if (expiration){
            //token无效
            return Result.build(null, ResultCodeEnum.TOKEN_ERROR);
        }
        //从token解析出 用户id+用户类型
        Long userId=JwtHelper.getUserId(token);
        Integer userType=JwtHelper.getUserType(token);

        //判断登录状态
        Map<String,Object> map=new LinkedHashMap<>();
        //用户类型
        switch (userType){
            case 1:
                //根据adminid查询一个对象，键值对
                Admin admin=adminService.getAdminById(userId);
                map.put("userType",1);
                map.put("user",admin);
                break;
            case 2:
                Student student=studentService.getStudentById(userId);
                map.put("userType",2);
                map.put("user",student);
                break;
            case 3:
                Teacher teacher=teacherService.getByTeacherById(userId);
                map.put("userType",3);
                map.put("user",teacher);
                break;
        }
        return Result.ok(map);
    }







    /*
     * 登录校验
     * */
    @ApiOperation("登录的方法")
    @PostMapping("/login")
    //传入两个参数，一个是系统的验证码图片，一个是用户输入的验证码
    public Result login(@ApiParam("登录提交的表单")@RequestBody LoginForm loginForm,HttpServletRequest request){

        //验证码
        HttpSession session=request.getSession();
        String sessionVerifiCode=(String) session.getAttribute("verifiCode");
        String loginVerifiCode=loginForm.getVerifiCode();

        //验证码判断,是否失效或者为空
        if ("".equals(sessionVerifiCode ) || null==sessionVerifiCode){
            return  Result.fail().message("验证码失效，请刷新后重试");
        }

        //判断用户输入验证码和系统验证码是否相同，不区分大小写
        if (!sessionVerifiCode.equalsIgnoreCase(loginVerifiCode)){
            return Result.fail().message("验证码有误，请输入后重试");
        }

        //从session移除现有验证码
        session.removeAttribute("verifiCode");

        //分用户类型验证 管理员，学生，老师等
        //准备一个map用户存放响应的数据
        Map<String,Object> map=new LinkedHashMap<>();
        switch (loginForm.getUserType()){
            //管理员表
            case 1:
                try {
                    //传入的对象，判断登录，数据库中查询，找到为admin，如果为null,即没有找到。
                    Admin admin= adminService.login(loginForm);
                    if (null !=admin){
                        //用户的id 和类型，转换为一个密文，以token形式的名称反馈前端
                        String token= JwtHelper.createToken(admin.getId().longValue(),1);
                        map.put("token",token);
                    }else {
                        throw new RuntimeException("用户名或者密码有误");
                    }
                    return Result.ok(map);
                }catch (RuntimeException e){
                    e.printStackTrace();
                    //异常对象抛出来的信息   new RuntimeException("用户名或者密码有误");
                    return Result.fail().message(e.getMessage());
                }

                //学生信息
            case 2:
                try {
                    Student student= studentService.login(loginForm);
                    if (null !=student){
                        String token=JwtHelper.createToken(student.getId().longValue(),2);
                        map.put("token",token);
                    }else {
                        throw new RuntimeException("用户名或者密码错误");
                    }
                    return Result.ok(map);
                }catch (RuntimeException e){
                    e.printStackTrace();
                    return Result.fail().message(e.getMessage());
                }

            case 3:
                try {
                    Teacher teacher= teacherService.login(loginForm);
                    if (null !=teacher){
                        String token=JwtHelper.createToken(teacher.getId().longValue(),3);
                        map.put("token",token);
                    }else {
                        throw new RuntimeException("用户名或者密码错误");
                    }
                    return Result.ok(map);
                }catch (RuntimeException e){
                    e.printStackTrace();
                    return Result.fail().message(e.getMessage());
                }
        }

        return Result.fail().message("查无此人");

    }




    /*
    * 响应验证码图片的流程
    * 匹配处理器方法路径
    * */
    @ApiOperation("获取验证码方法")
    @GetMapping("/getVerifiCodeImage")
    public void getVerifiCodeImage(
            @ApiParam("请求") HttpServletRequest request,
            @ApiParam("响应") HttpServletResponse response){

        //获取图片
        BufferedImage verifiCodeImage= CreateVerifiCodeImage.getVerifiCodeImage();

        //获取图片上的验证码
        String verifiCode=new String(CreateVerifiCodeImage.getVerifiCode());

        //将验证码文本放入session 域，为下一次验证做准备
        HttpSession session=request.getSession();
        session.setAttribute("verifiCode",verifiCode);

        /*
        * 将验证码图片响应到浏览器  response输出流
        * 将生成的验证码图片，按照PNG格式传给浏览器。
        * */
        try {
            ServletOutputStream outputStream= response.getOutputStream();
            ImageIO.write(verifiCodeImage,"PNG",outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
