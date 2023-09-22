package aopxml;

import org.springframework.stereotype.Component;

/**
 * @projectName: summer_plans
 * @package: aopxml
 * @className: BookProxy
 * @author: ktrol
 * @description: TODO
 * @date: 2023/7/9 17:37
 * @version: 1.0
 */

@Component("bp")
public class BookProxy {

    public void Before(){
        System.out.println("请先付款：");
    }
}
