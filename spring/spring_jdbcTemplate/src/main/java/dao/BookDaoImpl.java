package dao;

import entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/10/10:39
 */

@Repository
public class BookDaoImpl implements BookDao{

    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //实现添加书籍操作
    @Override
    public void add(Book book){
        //创建SQL语句
        String sql="insert into book values(?,?,?)";
        //调用方法实现
        Object[] args={book.getId(),book.getBookname(),book.getBookstuts()};
        int update=jdbcTemplate.update(sql,args);
        System.out.println(update);
    }


    //实现修改书籍的操作
    @Override
    public void updateBook(Book book){

        //创建SQL语句
        String sql="update book set bookname=?,bookstuts=? where id=?";
        //调用方法实现
        Object[] args={book.getBookname(),book.getBookstuts(), book.getId()};
        int update=jdbcTemplate.update(sql,args);
        System.out.println(update);

    }


    //实现删除书籍的操作
    @Override
    public void deleteBook(int id){

        //创建SQL语句
        String sql="delete from book where id=?";
        //调用方法实现
        int update=jdbcTemplate.update(sql,id);
        System.out.println(update);
    }


    //实现查询操作

    @Override
    public int selectBook(){

        String sql="select count(*) from book";
        Integer integer=jdbcTemplate.queryForObject(sql,Integer.class);

        return integer;
    }


    //查询返回对象
    @Override
    public Book selectObj(int id){

        String sql="select * from book where id=?";
        Book book=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Book>(Book.class),2);
        return book;

    }



    //测试集合
    @Override
    public List<Book> find(){

        String sql="select * from book";
        List<Book> bookList=jdbcTemplate.query(sql,new BeanPropertyRowMapper<Book>(Book.class));
        return bookList;

    }


    //批量
    @Override
    public void batchadd(List<Object[]> batchargs){
        //创建SQL语句
        String sql="insert into book values(?,?,?)";
        int[] ints=jdbcTemplate.batchUpdate(sql,batchargs);

    }

    //批量修改
    @Override
    public void batchupdate(List<Object[]> batchargs) {

        //创建SQL语句
        String sql="update book set bookname=?,bookstuts=? where id=?";
        //调用方法实现
        int[] ints=jdbcTemplate.batchUpdate(sql,batchargs);

    }

    //测试批量删除
    @Override
    public void batchdelete(List<Object[]> batchargs) {

        //创建SQL语句
        String sql="delete from book where id=?";

        //调用方法实现
        int[] ints=jdbcTemplate.batchUpdate(sql,batchargs);

    }


}
