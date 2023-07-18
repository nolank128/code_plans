package mapper;

import pojo.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/18/10:06
 */
public interface UserMapper {
    /*
    * MyBatis面向接口编程一致
    * mapper接口的全类名和映射文件的命名空间（namespace）保持一致
      mapper接口中方法的方法名和映射文件中编写SQL的标签的id属性保持一致
      *
      * 表--实体类--mapper接口---映射文件
    * */

    /*
    * 添加用户信息
    * */
    int insertUser();

    /*
    * 修改用户信息
    * */

    void updateUser();


    /*
    * 删除用户信息
    * */
    int deleteUser();

    /*
    * 查询用户信息
    * */

    User getUserById();

    /*
    *
    * 查询所有用户
    * */
    List<User> getAllUser();

}
