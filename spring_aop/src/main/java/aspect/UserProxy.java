package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @projectName: summer_plans
 * @package: aspect
 * @className: UserProxy
 * @author: ktrol
 * @description: TODO
 * @date: 2023/7/9 15:29
 * @version: 1.0
 */


/*
* 增强的类
* */

@Component("up")
@Aspect   //生成代理对象
@Order(4)
public class UserProxy {

    public UserProxy() {
    }

    //相同切入点
    @Pointcut(value = "execution(* aspect.*.add())")
    public void pointcut(){

    }




    //前置通知
    //@Before注解表示前置通知
    @Before(value = "pointcut()")
    public void before(){
        System.out.println("before 前置通知");
    }

    //后置通知（返回值后通知）
    @AfterReturning(value = "execution(* aspect.*.destory())")
    public void afterReturning() {
        System.out.println("afterReturning.........");
    }

    //最终通知（不管有无异常都执行）
    @After(value = "execution(* aspect.*.add())")
    public void after() {
        System.out.println("after.........");
    }

    //异常通知（）
    @AfterThrowing(value = "execution(* aspect.*.add())")
    public void afterThrowing() {
        System.out.println("afterThrowing.........");
    }


    //环绕通知（方法之前和之后都通知）
    @Around(value = "execution(* aspect.*.add())")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前.........");

        //被增强的方法执行
        proceedingJoinPoint.proceed();

        System.out.println("环绕之后.........");
    }


}
