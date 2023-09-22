package Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/12/10:22
 */


@Configuration//配置类,完全注解配置，无需xml文件
@ComponentScan(basePackages = {"Config","beans","dao","service"})
public class config {


}
