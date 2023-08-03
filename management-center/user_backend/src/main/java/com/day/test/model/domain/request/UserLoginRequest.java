package com.day.test.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/*
* 用户登录请求体
* */

@Data
public class UserLoginRequest implements Serializable {


    private String userAccount;

    private String userPassword;


}
