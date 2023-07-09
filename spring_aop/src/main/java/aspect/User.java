package aspect;

import org.springframework.stereotype.Component;

/**
 * @projectName: summer_plans
 * @package: aspect
 * @className: User
 * @author: ktrol
 * @description: TODO
 * @date: 2023/7/9 15:28
 * @version: 1.0
 */


@Component("u")
public class User {

    public User() {
        System.out.println(" ");
    }

    public  void add(){

        System.out.println("add()");

    }


    public void destory(){
        System.out.println("销毁：");
    }
}
