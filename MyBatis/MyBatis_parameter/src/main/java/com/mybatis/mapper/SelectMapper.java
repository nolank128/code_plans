package com.mybatis.mapper;

import com.mybatis.pojo.user;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/19/21:49
 */
public interface SelectMapper {

    /*
    *  MyBatis的各种查询功能：
            1、若查询出的数据只有一条
            可以通过实体类对象接收,可以通过list集合接收,可以通过map集合接收
            2、若查询出的数据有多条
            可以通过实体类类型的list集合接收,可以通过map类型的list集合接收
            可以在mapper接口的方法上添加@MapKey注解，此时就可以将每条数据转换的map集合作为值，以某个字段的值作为键，放在同一个map集合中
            注意：一定不能通过实体类对象接收，此时会抛异常TooManyResultsException
    * */

    /**
     * 根据id查询用户信息
     */
    List<user> getUserById(@Param("id") Integer id);

    /**
     * 查询所有的用户信息
     */
    List<user> getAllUser();

    /**
     * 查询用户信息的总记录数
     */
    Integer getCount();

    /**
     * 根据id查询用户信息为一个map集合
     * 可以在mapper接口的方法上添加@MapKey注解，此时就可以将每条数据转换的map集合作为值，以某个字段的值作为键，放在同一个map集合中
     */
    @MapKey("username")
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);

    /**
     * 查询所有用户信息为map集合
     */

    //List<Map<String, Object>> getAllUserToMap();
    @MapKey("id")
    Map<String, Object> getAllUserToMap();

}
