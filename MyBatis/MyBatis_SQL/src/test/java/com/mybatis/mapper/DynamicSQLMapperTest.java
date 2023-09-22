package com.mybatis.mapper;

import com.alibaba.fastjson.JSONObject;
import com.mybatis.pojo.Emp;
import com.mybatis.utils.SqlSessionUtils;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/22/19:49
 */
public class DynamicSQLMapperTest extends TestCase {
    private static final Logger logger= LoggerFactory.getLogger(DynamicSQLMapperTest.class);


    /*
    * test01 ：
    * */
    @Test
    public void test01(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list=mapper.getEmpByCondition(new Emp(null,"",null," ",null)) ;
        String str= JSONObject.toJSONString(list);
        logger.info(str);

    }


    @Test
    public void test02(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list=mapper.getEmpByChoose(new Emp(null,"",null,"",null)) ;
        String str= JSONObject.toJSONString(list);
        logger.info(str);
    }


    @Test
    public void test03(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int result=mapper.deleteMoreByArray(new Integer[]{5,6});
        String str= JSONObject.toJSONString(String.valueOf(result));
        logger.info(str);
    }


    @Test
    public void test04(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null,"a1",23,"男",null);
        Emp emp2 = new Emp(null,"a2",21,"男",null);
        Emp emp3 = new Emp(null,"a3",23,"男",null);
        List<Emp> emps= Arrays.asList(emp1,emp2,emp3);

        String str= JSONObject.toJSONString(mapper.insertMoreByList(emps));
        logger.info(str);
    }



}