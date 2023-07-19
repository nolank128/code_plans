package com.mybatis.mapper;

import com.alibaba.fastjson.JSONObject;
import com.mybatis.pojo.user;
import com.mybatis.utils.SqlSessionUtils;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/19/21:52
 */
public class SQLMapperTest extends TestCase {

    private static final Logger logger= LoggerFactory.getLogger(SQLMapperTest.class);

    /*
    * test01 根据用户名模糊查询用户信息
    * test02 批量删除
    * test03 查询指定表中的数据
    * test04 添加用户信息
    * */

    @Test
    public void test01(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<user> list = mapper.getUserByLike("a");
        String str= JSONObject.toJSONString(list);
        logger.info(str);
    }


    @Test
    public void test02(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        int result=mapper.deleteMore("1,2,3");
        logger.info(String.valueOf(result));
    }

    @Test
    public void test03(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<user> user=mapper.getUserByTableName("user");
        String result=JSONObject.toJSONString(user);
        logger.info(String.valueOf(result));
    }

    @Test
    public void test04(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        user user=new user("cc", "123456", 2, "男",23 , null);
        mapper.insertUser(user);
        String str=JSONObject.toJSONString(user);
        logger.info(str);
    }



    @Test
    public void testJDBC() throws Exception {
        Class.forName("xxxx");
        Connection connection = DriverManager.getConnection("xxxx", "xxxx", "xxxx");
        PreparedStatement ps = connection.prepareStatement("insert XXXX ", Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        //获取自增主键
        ResultSet resultSet = ps.getGeneratedKeys();
    }



}