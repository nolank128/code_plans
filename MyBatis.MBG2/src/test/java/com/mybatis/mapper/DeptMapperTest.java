package com.mybatis.mapper;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatis.pojo.Emp;
import com.mybatis.pojo.EmpExample;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/24/17:24
 */
public class DeptMapperTest extends TestCase {
    private static final Logger logger= LoggerFactory.getLogger(DeptMapperTest.class);

    @Test
    public void test01(){
        try {
            //加载核心配置文件
            InputStream inputStream=Resources.getResourceAsStream("mybatis-config.xml");

            //获取SQLSessionFactoryBuilder
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();

            //获取sqlSessionFactory
            SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(inputStream);
            SqlSession sqlSession=sqlSessionFactory.openSession(true);
            EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);

            //查询所有数据
            List<Emp> list=empMapper.selectByExample(null);
            String str= JSONObject.toJSONString(list);
            logger.info(str);
            //根据条件查询
            EmpExample example=new EmpExample();
            example.createCriteria().andEmpNameIsNull().andAgeGreaterThanOrEqualTo(22);
            example.or().andAgeIsNull();
            List<Emp> emps=empMapper.selectByExample(example);
            String str2=JSONObject.toJSONString(emps);
            logger.info(str2);

        }catch (IOException e){
            e.printStackTrace();
        }

    }


    @Test
    public void test02(){
        try {
            //加载核心配置文件
            InputStream inputStream=Resources.getResourceAsStream("mybatis-config.xml");

            //获取SQLSessionFactoryBuilder
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();

            //获取sqlSessionFactory
            SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(inputStream);
            SqlSession sqlSession=sqlSessionFactory.openSession(true);
            EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);

            //选择性更改数据
            empMapper.updateByPrimaryKeySelective(new Emp(3,null,22,null,null,null));



        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Test
    public  void test04(){

        try {
            //加载核心配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //获取SQLSessionFactoryBuilder
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

            //获取sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);

        }catch (IOException e){
            e.printStackTrace();
        }
    }


    //测试分页功能

    /**
     * limit index,pageSize
     * index:当前页的起始索引
     * pageSize：每页显示的条数
     * pageNum：当前页的页码
     * index=(pageNum-1)*pageSize
     *
     * 使用MyBatis的分页插件实现分页功能：
     * 1、需要在查询功能之前开启分页
     * PageHelper.startPage(int pageNum, int pageSize);
     * 2、在查询功能之后获取分页相关信息
     * PageInfo<Emp> page = new PageInfo<>(list, 5);
     * list表示分页数据
     * 5表示当前导航分页的数量
     */

    @Test
    public void test06(){
        try {
            //加载核心配置文件
            InputStream inputStream=Resources.getResourceAsStream("mybatis-config.xml");

            //获取SQLSessionFactoryBuilder
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();

            //获取sqlSessionFactory
            SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(inputStream);
            SqlSession sqlSession=sqlSessionFactory.openSession(true);
            EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);

            //查询所有数据
            //Page<Object> page=PageHelper.startPage(2,3);
            //获取更多数据，使用pageinfo。
            PageHelper.startPage(2,2);
            List<Emp> list=empMapper.selectByExample(null);
            //list 分页数据 5 分页数量
            PageInfo<Emp> pageInfo=new PageInfo<>(list,5);

            logger.info(String.valueOf(pageInfo));
            String str= JSONObject.toJSONString(list);
            logger.info(str);
        }catch (IOException e){
            e.printStackTrace();
        }

    }





}