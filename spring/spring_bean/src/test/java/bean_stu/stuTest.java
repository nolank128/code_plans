package bean_stu;

import bean.Emp;
import beans.mybean;
import beans.orders;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.xdevapi.JsonArray;
import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/11/21:36
 */
public class stuTest extends TestCase {
    public static final Logger logger= LoggerFactory.getLogger("stuTest.class");

    /*
    * test01 测试四种类型注入
    * test02  测试list<>型注入
    * test03 测试工厂bean
    * test04 测试初始化，销毁方法等流程
    * test05 测试自动装配
    * */

    @Test
    public void test01(){
        AbstractApplicationContext abstractApplicationContext=new ClassPathXmlApplicationContext("bean2.xml");
         stu stu=abstractApplicationContext.getBean("stu", bean_stu.stu.class);
         String str= JSONObject.toJSONString(stu);
         logger.info(str);
    }

    @Test
    public void test02(){
        AbstractApplicationContext abstractApplicationContext=new ClassPathXmlApplicationContext("bean3.xml");
        book book=abstractApplicationContext.getBean("book", bean_stu.book.class);
        String str= JSONObject.toJSONString(book);
        logger.info(str);
    }



    @Test
    public void test03(){
        AbstractApplicationContext abstractApplicationContext=new ClassPathXmlApplicationContext("bean4.xml");
        course course =abstractApplicationContext.getBean("myBeanPost", bean_stu.course.class);
        String str= JSONObject.toJSONString(course);
        logger.info(str);

    }


    @Test
    public void test04(){
        AbstractApplicationContext abstractApplicationContext=new ClassPathXmlApplicationContext("bean4.xml");

        orders orders=abstractApplicationContext.getBean("orders", beans.orders.class);
        String str= JSONObject.toJSONString(orders);
        logger.info("第四步 获取创建bean实例对象");
        abstractApplicationContext.close();
        logger.info(str);
    }

    @Test
    public void test05(){
        AbstractApplicationContext abstractApplicationContext=new ClassPathXmlApplicationContext("bean5.xml");
        Emp emp =abstractApplicationContext.getBean("emp", Emp.class);
        String str= JSONObject.toJSONString(emp);
        logger.info(str);

    }







}