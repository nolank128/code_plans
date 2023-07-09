package aopxml;

import com.alibaba.fastjson.JSONObject;
import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class BookProxyTest extends TestCase {
    private static final Logger logger= LoggerFactory.getLogger("BookProxyTest.class");

    /*
    *  test01 测试配置文件实现aop
    *
    * */

    @Test
    public void test01(){
        AbstractApplicationContext abstractApplicationContext=new ClassPathXmlApplicationContext("aopxml.xml");
        Book book=abstractApplicationContext.getBean("book",Book.class);
        book.buy();

        String str= JSONObject.toJSONString(book);
        logger.info(str);
    }
}