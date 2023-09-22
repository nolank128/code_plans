package service;

import Config.config;
import com.alibaba.fastjson.JSONObject;
import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/12/10:33
 */
public class UserServiceTest extends TestCase {

    public static final Logger logger= LoggerFactory.getLogger(UserServiceTest.class);

    /*test01
    * test02 测试全部注解方式
    * */


    @Test
    public void test02() {
        //加载配置类
        ApplicationContext context
                = new AnnotationConfigApplicationContext(config.class);
        UserService userService = context.getBean("userService", UserService.class);
        String str= JSONObject.toJSONString(userService);
        userService.add();
        logger.info(str);
    }


}