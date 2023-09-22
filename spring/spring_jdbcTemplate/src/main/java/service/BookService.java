package service;

import dao.BookDao;
import entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/10/10:38
 */



@Service
public class BookService {

    //注入Dao
    @Autowired
    private BookDao bookDao;


    //添加方法
    public void addbook(Book book){
         bookDao.add(book);
    }

    //修改的方法
    public void updateBook(Book book){
        bookDao.updateBook(book);
    }
    //删除的方法

    public  void deleteBook(int id){
        bookDao.deleteBook(id);
    }



    //查询操作

    public int  select(){
        return bookDao.selectBook() ;
    }


    //查询对象
    public Book selectobj(int id){
        return bookDao.selectObj(id) ;
    }

    //查询集合
    public List<Book> findAll(){
        return bookDao.find();
    }


    //批量添加
    public void  batchadd(List<Object[]> batchargs){
         bookDao.batchadd(batchargs);
    }


    //批量修改
    public void batchupdate(List<Object[]> batchargs){

        bookDao.batchupdate(batchargs);
    }


    //批量删除语句
    public void batchdelete(List<Object[]> batchargs ){
        bookDao.batchdelete(batchargs);
    }

}
