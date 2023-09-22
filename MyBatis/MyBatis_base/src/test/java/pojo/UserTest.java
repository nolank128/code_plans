package pojo;

import com.alibaba.fastjson.JSONObject;
import junit.framework.TestCase;
import mapper.UserMapper;
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
 * @Date: 2023/07/18/11:00
 */
public class UserTest extends TestCase {

    private static Logger logger= LoggerFactory.getLogger(UserTest.class);

    /*
    * test01 测试添加用户
    * test02 测试更新用户信息
    * test03 测试删除用户
    *
    * */


    //测试添加用户

    @Test
    public void test01() throws IOException {
        //加载核心配置文件
        InputStream inputStream=Resources.getResourceAsStream("mybatis-config.xml");

        //获取SQLSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();

        //获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(inputStream);

        //获取sqlsession
        //sqlsession 自动提交，设置为TRUE即可。默认不自动提交。
        SqlSession sqlSession=sqlSessionFactory.openSession(true);

        //获取mapper接口对象
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        //String str= JSONObject.toJSONString(userMapper);

        //插入功能
        int result=userMapper.insertUser();
        //提交事务
        //sqlSession.commit();

        //logger.info(str);

        logger.info("插入数据完成");
    }

    //测试test02 测试添加用户
    @Test
    public void test02() throws IOException {
        InputStream inputStream=Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);

        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser();
        logger.info("修改完成");

    }



    //测试test03 测试删除用户
    @Test
    public void test03() throws IOException {
        InputStream inputStream=Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);

        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser();
        logger.info("删除完成");

    }


    //测试test04 测试查询用户
    @Test
    public void test04() throws IOException {
        InputStream inputStream=Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);

        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user=userMapper.getUserById();
        String str=JSONObject.toJSONString(user);

        logger.info("查询完成"+str);

    }

    //测试test05 查询用户
    @Test
    public void test05() throws IOException {
        InputStream inputStream=Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);

        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        List<User> user=userMapper.getAllUser();
         String str=JSONObject.toJSONString(user);
        logger.info("查询完成"+str);

    }



}