package com.mybatis.mapper;

import com.mybatis.pojo.user;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/19/21:48
 */
public interface SQLMapper {

    /**
     * 根据用户名模糊查询用户信息
     */
    List<user> getUserByLike(@Param("username") String username);

    /**
     * 批量删除
     */
    int deleteMore(@Param("ids") String ids);

    /*
     * 动态获取表名来查询信息
     * 查询指定表中的数据
     */
    List<user> getUserByTableName(@Param("tableName") String tableName);

    /**
     * 添加用户信息
     */
    void insertUser(user user);


}
