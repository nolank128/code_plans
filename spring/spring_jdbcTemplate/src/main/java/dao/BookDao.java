package dao;


import entity.Book;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/10/10:39
 */
public interface BookDao {


    void add(Book book);


    void updateBook(Book book);

    void deleteBook(int id);

    int  selectBook();

    Book selectObj(int id);

    List<Book> find();


    void batchadd(List<Object[]> batchargs);

    void batchupdate(List<Object[]> batchargs);

    void batchdelete(List<Object[]> batchargs);
}
