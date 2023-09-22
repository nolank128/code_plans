package com.project.smart_campus.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/27/10:40
 */


public final class MD5 {

    public static String encrypt(String strSrc) {
        try {
            char hexChars[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
                    '9', 'a', 'b', 'c', 'd', 'e', 'f' };

            //getBytes(String charsetName): 使用指定的字符集将字符串编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
            byte[] bytes = strSrc.getBytes();

            //获取MD5摘要算法的MessageDiges 的对象
            MessageDigest md=MessageDigest.getInstance("MD5");
            //使用了指定字节更新摘要
            md.update(bytes);

            //对于给定数量的更新数据，digest 方法只能被调用一次。在调用 digest 之后，MessageDigest 对象被重新设置成其初始状态。
            bytes = md.digest();

            // 获取初识状态下摘要的长度
            int j = bytes.length;
            char[] chars = new char[j * 2];
            int k = 0;
            for (int i = 0; i < bytes.length; i++) {
                byte b = bytes[i];
                chars[k++] = hexChars[b >>> 4 & 0xf];
                chars[k++] = hexChars[b & 0xf];
            }

            //返回加密后的md5密钥串
            return new String(chars);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("MD5加密出错！！+" + e);
        }

    }


}
