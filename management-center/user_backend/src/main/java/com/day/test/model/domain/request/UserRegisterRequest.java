package com.day.test.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/*
* 用户注册请求体
* */

@Data
public class UserRegisterRequest implements Serializable {


    private String userAccount;
    public String  userPassword;
    public String checkPassword;
    public String planetCode;
}
