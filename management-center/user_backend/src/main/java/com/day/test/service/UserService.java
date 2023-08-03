package com.day.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.day.test.model.domain.User;

import javax.servlet.http.HttpServletRequest;

/*
 * 用户服务
 * */
public interface UserService extends IService<User> {

    /**
     * 用户注释
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验码
     * @return 新用户id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword,String planetCode);

    /**
     * 用户登录
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @return  返回脱敏后的用户信息
     */

    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     * @param originUser
     * @return
     */

    User getSafetyUser(User originUser);

    /**
     * 用户注销
     *
     * @param request
     * @return
     */
    int userLogout(HttpServletRequest request);
}
