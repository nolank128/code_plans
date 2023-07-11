package service;

import com.alibaba.fastjson.JSONObject;
import dao.User;
import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/11/9:50
 */
public class UserServiceTest extends TestCase {

    public static final Logger logger= LoggerFactory.getLogger(UserServiceTest.class);


    /*
    * test01:使用转账案例测试事务特性
    * test02：使用xml方式配置事务
    * test03:测试全部注解方式实现
    * test04: 函数式注册对象测试
    * */


    @Test
    public void test01(){
        AbstractApplicationContext abstractApplicationContext=new ClassPathXmlApplicationContext("jdbc2.xml");

        UserService userService=abstractApplicationContext.getBean("userService" ,UserService.class);
        userService.accountMoney();
        String s= JSONObject.toJSONString(userService);
        logger.info(s);

    }


    @Test
    public void test02(){
        AbstractApplicationContext abstractApplicationContext=new ClassPathXmlApplicationContext("bean.xml");

        UserService userService=abstractApplicationContext.getBean("userService" ,UserService.class);
        userService.accountMoney();
        String s= JSONObject.toJSONString(userService);
        logger.info(s);


    }


    @Test
    public void test03 (){
        AbstractApplicationContext abstractApplicationContext=new AnnotationConfigApplicationContext(config.config.class);

        UserService userService=abstractApplicationContext.getBean("userService" ,UserService.class);
        userService.accountMoney();
        String s= JSONObject.toJSONString(userService);
        logger.info(s);


    }


    //函数式注册对象
    @Test
    public void test04(){
        //1 创建GenericApplicationContext对象
        GenericApplicationContext genericApplicationContext = new GenericApplicationContext();
        //2 调用context的方法对象注册
        genericApplicationContext.refresh();//清空
        genericApplicationContext.registerBean("user1", User.class,() -> new User());
        //3 获取在spring注册的对象
        User user0 = (User)genericApplicationContext.getBean("user1");
        String str0=JSONObject.toJSONString(user0);
        logger.info(str0);
    }



}