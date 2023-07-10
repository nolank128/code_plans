package entity;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/10/11:32
 */
public class Book {
    private int id;
    private String bookname;
    private String bookstuts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookstuts() {
        return bookstuts;
    }

    public void setBookstuts(String bookstuts) {
        this.bookstuts = bookstuts;
    }


}
