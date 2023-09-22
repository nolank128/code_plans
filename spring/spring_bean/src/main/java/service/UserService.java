package service;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/10/22:23
 */

//在注解里面value属性值可以省略不写，
//默认值是类名称，首字母小写
//UserService -- userService
//@Component(value = "userService")
// <bean id="userService" class=".."/>

@Service
public class UserService {

    /*//创建UserDao类型属性，生成set方法
    private UserDao userDao;*/

    @Value(value = "alice")
    private String name;


    //定义dao类型属性
    //不需要添加set方法
    //添加注入属性注解
    // @Autowired  //根据类型进行注入
    // @Qualifier(value = "userdaoImpl") //根据名称进行注入
    //private UserDao userDao;
    @Resource(name = "userdaoImpl") //根据名称进行注入
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add() {
        System.out.println("使用了方法UserService.add()");
        userDao.update();
    }



}
