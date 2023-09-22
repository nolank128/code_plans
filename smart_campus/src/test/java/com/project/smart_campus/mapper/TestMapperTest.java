package com.project.smart_campus.mapper;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/26/22:04
 */

@SpringBootTest
class TestMapperTest {
    private static final Logger logger= LoggerFactory.getLogger(TestMapperTest.class);


    @Resource
    TestMapper testMapper;



    /*
    * test01 测试分页功能
    *
    * */
    @Test
    public void test01(){
        Page<com.project.smart_campus.pojo.Test> page=new Page<>(1,3);
        List<com.project.smart_campus.pojo.Test> list=testMapper.findPageTest(page);
        String str= JSONObject.toJSONString(list);
        page.setRecords(list);
        logger.info("ok");

    }


}