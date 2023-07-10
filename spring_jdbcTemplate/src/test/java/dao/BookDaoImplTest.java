package dao;

import com.alibaba.fastjson.JSONObject;
import entity.Book;
import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BookService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/10/11:45
 */


/*
* test01 测试
* */
public class BookDaoImplTest extends TestCase {


    private static final Logger logger= LoggerFactory.getLogger(BookDaoImplTest.class);


    /*
    * test01：测试添加
    * test02：测试修改
    * test03 测试删除
    * test04 ：测试查询
    *test05 测试fastjson，数据库返回对象
    *test06 测试集合
    *test07批量操作数据库
    *test08： 批量修改和删除
    *test09 批量删除
    * */

    //test01：测试添加
    @Test
    public  void test01(){
        AbstractApplicationContext abstractApplicationContext=new ClassPathXmlApplicationContext("jdbc.xml");
        BookService bookService=abstractApplicationContext.getBean("bookService",BookService.class);

        Book book=new Book();
        book.setId(2);
        book.setBookname("abc");
        book.setBookstuts("ok");
        bookService.addbook(book);

        String str= JSONObject.toJSONString(book);
        logger.info(str);

    }


    //test02 测试修改
    public void test02(){
        AbstractApplicationContext abstractApplicationContext=new ClassPathXmlApplicationContext("jdbc.xml");
        BookService bookService=abstractApplicationContext.getBean("bookService",BookService.class);

        Book book=new Book();
        book.setId(2);
        book.setBookname("abc");
        book.setBookstuts("error");
        bookService.updateBook(book);

        String str= JSONObject.toJSONString(book);
        logger.info(str);

    }

    //test03 测试删除
    @Test
    public void test03(){
        AbstractApplicationContext abstractApplicationContext=new ClassPathXmlApplicationContext("jdbc.xml");
        BookService bookService=abstractApplicationContext.getBean("bookService",BookService.class);

        Book book=new Book();

        bookService.deleteBook(1);

        String str= JSONObject.toJSONString(book);
        logger.info(str);

    }


    //test04 ：测试SQL查询
    @Test
    public void test04(){
        AbstractApplicationContext abstractApplicationContext=new ClassPathXmlApplicationContext("jdbc.xml");
        BookService bookService=abstractApplicationContext.getBean("bookService",BookService.class);

        Book book=new Book();

        int count=bookService.select();
        logger.info(String.valueOf(count));

        String str= JSONObject.toJSONString(book);
        logger.info(str);

    }



    //test05 测试fastjson，数据库返回对象
    @Test
    public void test05(){

        AbstractApplicationContext abstractApplicationContext=new ClassPathXmlApplicationContext("jdbc.xml");
        BookService bookService=abstractApplicationContext.getBean("bookService",BookService.class);

        Book book=bookService.selectobj(1);
        String str= JSONObject.toJSONString(book);
        logger.info(str);

    }

    //test06 测试集合

    @Test
    public void test06(){

        AbstractApplicationContext abstractApplicationContext=new ClassPathXmlApplicationContext("jdbc.xml");
        BookService bookService=abstractApplicationContext.getBean("bookService",BookService.class);

        List<Book> bookList=bookService.findAll();
        String str= JSONObject.toJSONString(bookList);
        logger.info(str);

    }

    //test07 批量操作数据库
    @Test
    public void test07(){
        AbstractApplicationContext abstractApplicationContext=new ClassPathXmlApplicationContext("jdbc.xml");
        BookService bookService=abstractApplicationContext.getBean("bookService",BookService.class);

        List<Object[]> objects=new ArrayList<>();
        Object[] objects1={3,"book1", "ok"};
        Object[] objects2={4,"book2", "ok"};
        Object[] objects3={5,"book3", "ok"};

        objects.add(objects1);
        objects.add(objects2);
        objects.add(objects3);

        bookService.batchadd(objects);

        String str= JSONObject.toJSONString(objects);
        logger.info(str);

    }


    // test08： 批量修改和删除
    @Test
    public void test08(){
        AbstractApplicationContext abstractApplicationContext=new ClassPathXmlApplicationContext("jdbc.xml");
        BookService bookService=abstractApplicationContext.getBean("bookService",BookService.class);

        List<Object[]> objects=new ArrayList<>();
        Object[] objects1={"book3", "ok",3};
        Object[] objects2={"book4", "ok",4};
        Object[] objects3={"book5", "ok",5};

        objects.add(objects1);
        objects.add(objects2);
        objects.add(objects3);

        bookService.batchupdate(objects);

        String str= JSONObject.toJSONString(objects);
        logger.info(str);
    }


    //test09 批量删除
    public void test09(){

        AbstractApplicationContext abstractApplicationContext=new ClassPathXmlApplicationContext("jdbc.xml");
        BookService bookService=abstractApplicationContext.getBean("bookService",BookService.class);

        List<Object[]> objects=new ArrayList<>();
        Object[] objects1={3};
        Object[] objects2={4};


        objects.add(objects1);
        objects.add(objects2);

        bookService.batchdelete(objects);

        String str= JSONObject.toJSONString(objects);
        logger.info(str);

    }


}