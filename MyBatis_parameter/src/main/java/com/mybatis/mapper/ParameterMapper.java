package com.mybatis.mapper;


import com.mybatis.pojo.user;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/19/15:47
 */
public interface ParameterMapper {

    /**
     * 查询所有的员工信息
     * @return
     */
    List<user> getAllUser();


    /**
     * 根据用户名查询用户信息
     */
    user getUserByUsername(String username);

    /**
     * 验证登录
     */
    user checkLogin(String username, String password);


    /**
     * 验证登录（参数为map）
     */
    user checkLoginByMap(Map<String, Object> map);

    /**
     * 添加用户信息
     */
    int insertUser(user user);


    /**
     * 验证登录（使用@Param）
     */
    user checkLoginByParam(@Param("username") String username, @Param("password") String password);

}
