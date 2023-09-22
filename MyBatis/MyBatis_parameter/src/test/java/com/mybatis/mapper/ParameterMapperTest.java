package com.mybatis.mapper;

import com.alibaba.fastjson.JSONObject;
import com.mybatis.pojo.user;
import com.mybatis.utils.SqlSessionUtils;
import junit.framework.TestCase;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/19/16:27
 */
public class ParameterMapperTest extends TestCase {
    private static final Logger logger=LoggerFactory.getLogger(ParameterMapperTest.class);


    /*
    * test01 测试获取所有用户信息
    * test02 测试jdbc占位符
    * test03 测试mybatis中的占位符
    * */

    @Test
    public void test01(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        ParameterMapper parameterMapper=sqlSession.getMapper(ParameterMapper.class);
        List<user> list=parameterMapper.getAllUser();
        String str= JSONObject.toJSONString(list);
        logger.info(str);

    }


    /*
    * 测试占位符
    * */
    @Test
    public void test02()throws Exception{
        String username = "test";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(".....", "...", "....");
        PreparedStatement ps = connection.prepareStatement("selelt * from user where username = ?");
        ps.setString(1, username);
        logger.info("测试成功");
    }


    @Test
    public void test03(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        ParameterMapper parameterMapper=sqlSession.getMapper(ParameterMapper.class);
        user user=parameterMapper.getUserByUsername("test");
        String str= JSONObject.toJSONString(user);
        logger.info(str);

    }

    /*
    *测试多参数
    * */
    @Test
    public void test04(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        ParameterMapper parameterMapper=sqlSession.getMapper(ParameterMapper.class);
        user user=parameterMapper.checkLogin("test","test");
        String str= JSONObject.toJSONString(user);
        logger.info(str);

    }


    /*
    * 测试集合
    * */

    @Test
    public void test05(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        ParameterMapper parameterMapper=sqlSession.getMapper(ParameterMapper.class);
        Map<String,Object> map=new HashMap<>();
        map.put("username","test");
        map.put("password","test");
        user user=parameterMapper.checkLoginByMap(map);
        String str= JSONObject.toJSONString(user);
        logger.info(str);

    }


    /*
    *test06 测试通过#{}等方式访问属性值
    * */

    @Test
    public void test06(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        ParameterMapper parameterMapper=sqlSession.getMapper(ParameterMapper.class);
        int result=parameterMapper.insertUser(new user("bob","root",5,"男",23,null));
        logger.info(String.valueOf(result));

    }


    /*
    * 测试@Param注解
    * */

    @Test
    public void test07(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        ParameterMapper parameterMapper=sqlSession.getMapper(ParameterMapper.class);
        user user=parameterMapper.checkLoginByParam("test","test");
        String str= JSONObject.toJSONString(user);
        logger.info(str);

    }



}