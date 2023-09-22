package com.project.smart_campus.util;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/27/12:05
 */
class MD5Test {

    private static final Logger logger= LoggerFactory.getLogger(MD5Test.class);

    /*
    * test01: 测试MD5加密
    * */

    @Test
    public void test01(){

        String str="alice";
        MD5 md5=new MD5();
        String s=md5.encrypt(str);

        String s1="alice";
        String s2=md5.encrypt(s1);
        boolean b=s2.equals(s);
        logger.info(String.valueOf(b));

    }

}