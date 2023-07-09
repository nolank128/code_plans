package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @projectName: summer_plans
 * @package: config
 * @className: ConfigAop
 * @author: ktrol
 * @description: TODO
 * @date: 2023/7/9 17:54
 * @version: 1.0
 */


@Component
@ComponentScan(basePackages = {"config"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {
    
}
