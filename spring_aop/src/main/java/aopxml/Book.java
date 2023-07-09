package aopxml;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @projectName: summer_plans
 * @package: aopxml
 * @className: Book
 * @author: ktrol
 * @description: TODO
 * @date: 2023/7/9 17:33
 * @version: 1.0
 */

/*
*
* */

@Component("b")

public class Book {

    public void buy(){

        System.out.println("购买成功：");
    }
}
