package dao;

import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/10/22:23
 */

@Repository(value = "userdaoImpl")
public class UserDaoImpl implements UserDao {

    @Override
    public void update() {
        System.out.println("使用了方法update（）；");
    }

    @Override
    public void reduce(){
        System.out.println("使用了reduce()方法");
    }
}
