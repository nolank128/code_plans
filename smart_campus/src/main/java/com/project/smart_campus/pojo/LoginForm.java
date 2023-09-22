package com.project.smart_campus.pojo;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/27/21:53
 */

@Data
public class LoginForm {
    /*
    * 接受前端传来的数据
    * 请求体
    * 用户名，密码，验证码，权限
    * */
    private String username;
    private String password;
    private String verifiCode;
    private Integer userType;

}
