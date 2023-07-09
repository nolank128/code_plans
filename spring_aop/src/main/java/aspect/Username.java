package aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @projectName: summer_plans
 * @package: aspect
 * @className: Username
 * @author: ktrol
 * @description: TODO
 * @date: 2023/7/9 17:27
 * @version: 1.0
 */

@Component
@Aspect
@Order(2)
public class Username {

    @Before(value = "execution(* aspect.*.add())")
    public void before(){
        System.out.println("执行：");
    }
}
