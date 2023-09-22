package service;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/11/9:36
 */

@Service
//@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE,readOnly = false,timeout = -1)//设置事务传播行为，隔离级别,超时等
public class UserService {


    //注入dao
    @Autowired
    private UserDao userDao;

    //转账方法
    public void  accountMoney(){

        /*userDao.reduce();
        int i=10/0;
        userDao.add();*/

        try {

            /* * 1.开启事务
             * 2、业务操作
             * 3、若没有发生异常，提交事务
             * 4.若发生异常，事务回滚
             * */
            userDao.reduce();
            int i=10/0;
            userDao.add();

        }catch (Exception e){

        }

    }
}
