package bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/10/21:06
 */
public class User {

    public String userName;

    public User() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public User(String userName) {
        this.userName = userName;
    }

    public void add(){
        System.out.println("使用了");
    }
}
