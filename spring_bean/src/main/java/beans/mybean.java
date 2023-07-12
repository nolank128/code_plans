package beans;

import bean_stu.course;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/11/21:46
 */
public class mybean implements FactoryBean<course> {


    //定义返回bean
    @Override
    public course getObject() throws Exception {
        course course = new course();
        course.setCname("abc");
        return course;
    }



    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }





}
