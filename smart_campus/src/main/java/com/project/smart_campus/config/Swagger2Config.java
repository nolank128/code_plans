package com.project.smart_campus.config;

import com.google.common.base.Predicates;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/26/17:29
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket webApiConfig(){

        //添加head参数start
        List<Parameter> parameters=new ArrayList<>();
        ParameterBuilder tokenPar=new ParameterBuilder();
        tokenPar.name("userId")
                .description("测试用户1")
                .defaultValue("1")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        parameters.add(tokenPar.build());

        ParameterBuilder tmpPar = new ParameterBuilder();
        tmpPar.name("userTempId")
                .description("测试用户2")
                .defaultValue("1")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        parameters.add(tmpPar.build());
        //添加head参数end

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                //用来创建该API的基本信息，展示在文档页面中（自定义展示的信息）
                .apiInfo(webApiInfo())
                //设置哪些接口暴露给swagger展示
                .select()

                //可以测试请求头中：输入token

                //.apis(RequestHandlerSelectors.withClassAnnotation(ApiOperation.class)) 扫描所有注解的 api
                .apis(RequestHandlerSelectors.basePackage("com.project.smart_campus.controller")) //扫描指定包中swagger注解
                //.apis(RequestHandlerSelectors.any()) 扫描所有
                //过滤掉admin路径下的所有页面
                //.paths(Predicates.and(PathSelectors.regex("/sms/.*")))
                //过滤掉所有error或error.*页面
                //.paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .globalOperationParameters(parameters);

    }

    private ApiInfo webApiInfo(){

        return new ApiInfoBuilder()
                .title("网站-API文档")
                .description("本文档描述了网站微服务接口定义")
                .version("1.0")
                .contact(new Contact("sc", "http://mypoject.com", "123456@qq.com"))
                .build();
    }

    private ApiInfo adminApiInfo(){

        return new ApiInfoBuilder()
                .title("后台管理系统-API文档")
                .description("本文档描述了后台管理系统微服务接口定义")
                .version("1.0")
                .contact(new Contact("sc", "http://mypoject.com", "123456@qq.com"))
                .build();
    }


}
