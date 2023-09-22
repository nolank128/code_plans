package beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/11/21:11
 */
public class beanpost implements BeanPostProcessor {

    @Override
    //初始化之前执行的方法，返回一个对象。   参数注入
    public Object postProcessBeforeInitialization(Object bean,String beanName)throws BeansException {
        System.out.println("在初始化之前执行的方法");
        return bean;
    }

    @Override
    //初始化之后执行的方法，返回一个对象
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("在初始化之后执行的方法");
        return bean;
    }


}
