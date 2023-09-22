package com.mybatis.mapper;

import com.alibaba.fastjson.JSONObject;
import com.mybatis.pojo.user;
import com.mybatis.utils.SqlSessionUtils;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/19/22:19
 */
public class SelectMapperTest extends TestCase {
    private static final Logger logger= LoggerFactory.getLogger(SelectMapperTest.class);


    /*
    * test01 根据id查询用户信息
    * test02 查询所有的用户信息
    * test03 查询用户信息的总记录数
    * test04 根据id查询用户信息为一个map集合
    * test05 查询所有用户信息为map集合
    * */
    @Test
    public void test01(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<user> user= mapper.getUserById(1);
        String str= JSONObject.toJSONString(user);
        logger.info(str);
    }

    @Test
    public void test02(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<user> user= mapper.getAllUser();
        String str= JSONObject.toJSONString(user);
        logger.info(str);
    }

    @Test
    public void test03(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer integer= mapper.getCount();
        logger.info(String.valueOf(integer));
    }

    @Test
    public void test04(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String,Object> map= mapper.getUserByIdToMap(1);
        String str=JSONObject.toJSONString(map);
        logger.info(str);

    }

    @Test
    public void test05(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String,Object> map= mapper.getAllUserToMap();
        String str=JSONObject.toJSONString(map);
        logger.info(str);

    }


}