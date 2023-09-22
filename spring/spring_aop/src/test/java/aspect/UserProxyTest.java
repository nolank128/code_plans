package aspect;

import com.alibaba.fastjson.JSONObject;
import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserProxyTest extends TestCase {

    private static final Logger logger= LoggerFactory.getLogger("UserProxyTest.class");

    /*
    * test01 测试前置通知
    * test02 测试后置通知
    * */


    @Test
    public void test01(){
        AbstractApplicationContext abstractApplicationContext=new ClassPathXmlApplicationContext("aop.xml");
        User user=abstractApplicationContext.getBean("u",User.class);
        user.add();
        String str= JSONObject.toJSONString(user);
        logger.info(str);
    }

    //测试后置通知

    @Test
    public void test02(){
        AbstractApplicationContext abstractApplicationContext=new ClassPathXmlApplicationContext("aop.xml");
        User user=abstractApplicationContext.getBean("u",User.class);
        user.destory();
        String str= JSONObject.toJSONString(user);
        logger.info(str);
    }


    //测试环绕通知
    @Test
    public void test03(){
        AbstractApplicationContext abstractApplicationContext=new ClassPathXmlApplicationContext("aop.xml");
        User user=abstractApplicationContext.getBean("u",User.class);
        user.add();
        String str= JSONObject.toJSONString(user);
        logger.info(str);
    }


    /*测试异常通知*/

    @Test
    public void test04(){
        AbstractApplicationContext abstractApplicationContext=new ClassPathXmlApplicationContext("aop.xml");
        User user=abstractApplicationContext.getBean("u",User.class);
        user.add();
        String str= JSONObject.toJSONString(user);
        logger.info(str);
    }

    //测试相同切入点
    @Test
    public void test05(){
        AbstractApplicationContext abstractApplicationContext=new ClassPathXmlApplicationContext("aop.xml");
        User user=abstractApplicationContext.getBean("u",User.class);
        user.add();
        String str= JSONObject.toJSONString(user);
        logger.info(str);
    }



}