package com.mybatis.mapper;

import com.alibaba.fastjson.JSONObject;
import com.mybatis.pojo.Dept;
import com.mybatis.pojo.Emp;
import com.mybatis.utils.SqlSessionUtils;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/20/21:51
 */
public class EmpMapperTest extends TestCase {

    private static final Logger logger= LoggerFactory.getLogger(EmpMapperTest.class);

    /*
    * test01:
    * test02:
    * */

    @Test
    public void test01(){

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.getAllEmp();
        String str= JSONObject.toJSONString(list);
        logger.info(str);

    }


    @Test
    public void test02(){

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp=mapper.getEmpAndDept(3);
        String str= JSONObject.toJSONString(emp);
        logger.info(str);

    }

    @Test
    public void test03(){

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp=mapper.getEmpAndDeptByStepOne(2);
        String str= JSONObject.toJSONString(emp);
        logger.info(str);

    }


    @Test
    public void test04(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept=mapper.getDeptAndEmp(1);
        String str= JSONObject.toJSONString(dept);
        logger.info(str);

    }


    @Test
    public void test05(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept=mapper.getDeptAndEmpByStepOne(1);
        String str= JSONObject.toJSONString(dept);
        logger.info(str);
    }




}