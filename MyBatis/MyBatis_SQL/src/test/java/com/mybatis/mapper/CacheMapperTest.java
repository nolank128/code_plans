package com.mybatis.mapper;

import com.alibaba.fastjson.JSONObject;
import com.mybatis.pojo.Emp;
import com.mybatis.utils.SqlSessionUtils;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.plaf.InputMapUIResource;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/23/10:18
 */
public class CacheMapperTest extends TestCase {
    private  static final Logger logger= LoggerFactory.getLogger(CacheMapperTest.class);


    /*
    * test01 测试缓存
    * test02 测试缓存失效操作
    * test03 测试手动清除缓存
    * */


    @Test
    public void test01(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        CacheMapper cacheMapper=sqlSession.getMapper(CacheMapper.class);
        Emp emp=cacheMapper.getEmpByEid(1);
        String str= JSONObject.toJSONString(emp);
        logger.info(str);

        Emp emp1=cacheMapper.getEmpByEid(1);
        String str1= JSONObject.toJSONString(emp1);
        logger.info(str1);

    }


    @Test
    public void test02(){
        SqlSession sqlSession=SqlSessionUtils.getSqlSession();
        CacheMapper cacheMapper=sqlSession.getMapper(CacheMapper.class);
        Emp emp=cacheMapper.getEmpByEid(1);
        String str=JSONObject.toJSONString(emp);
        logger.info(str);
        cacheMapper.insertEmp(new Emp(null,"test",22,null,null));
        Emp emp1=cacheMapper.getEmpByEid(1);
        String str1=JSONObject.toJSONString(emp1);
        logger.info(str1);

    }


    @Test
    public void test03(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        CacheMapper cacheMapper=sqlSession.getMapper(CacheMapper.class);
        Emp emp=cacheMapper.getEmpByEid(1);
        String str= JSONObject.toJSONString(emp);
        logger.info(str);
        //手动清空缓存
        sqlSession.clearCache();
        Emp emp1=cacheMapper.getEmpByEid(1);
        String str1= JSONObject.toJSONString(emp1);
        logger.info(str1);

    }



    @Test
    public void test04(){
        try {
            InputStream inputStream =Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession1=sqlSessionFactory.openSession(true);
            CacheMapper cacheMapper=sqlSession1.getMapper(CacheMapper.class);
            Emp emp1=cacheMapper.getEmpByEid(1);
            //System.out.println(emp1);
            sqlSession1.close();
            String str1=JSONObject.toJSONString(emp1);
            logger.info(str1);


            SqlSession sqlSession2=sqlSessionFactory.openSession(true);
            CacheMapper cacheMapper2=sqlSession2.getMapper(CacheMapper.class);
            Emp emp2=cacheMapper2.getEmpByEid(1);
            /*System.out.println(emp2);*/
            sqlSession2.close();
            String str2=JSONObject.toJSONString(emp2);
            logger.info(str2);

        }catch (IOException e){
            e.printStackTrace();
        }

    }

}