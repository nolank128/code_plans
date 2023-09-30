package com.bob.test;

import com.bob.bean.Users;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.xml.registry.infomodel.User;
import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        //java->json
        Users user = new Users();
        user.setUserName("Bob");
        user.setUserId(101);
        user.setSex("man");
        JSONObject obj = JSONObject.fromObject(user);
        Users bean = (Users) JSONObject.toBean(obj, Users.class);
        System.out.println(obj);
        System.out.println(bean);

        //json ->java
        String str ="{'sex':'man','userId':101,'userName':'Bob'}";
        JSONObject jsonObject = JSONObject.fromObject(str);
        Users   userBean = (Users) JSONObject.toBean(jsonObject, Users.class);
        System.out.println(userBean);

        //集合和json转换
        //1.list->json
        List list = new ArrayList();
        for (int i = 0; i < 5; i++) {
            Users kiki = new Users(i + 1, "KIKI" + i, "man");
            list.add(kiki);
        }
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println(jsonArray);

        //json ->list
        String str1= "[{\"sex\":\"man\",\"userId\":1,\"userName\":\"KIKI0\"},{\"sex\":\"man\",\"userId\":2,\"userName\":\"KIKI1\"},{\"sex\":\"man\",\"userId\":3,\"userName\":\"KIKI2\"},{\"sex\":\"man\",\"userId\":4,\"userName\":\"KIKI3\"},{\"sex\":\"man\",\"userId\":5,\"userName\":\"KIKI4\"}]";
        JSONArray jsonArray1 = JSONArray.fromObject(str1);
        Object[] array = (Object[]) JSONArray.toArray(jsonArray1, Users.class);
        for (Object o : array) {
            System.out.println(o.toString());
        }
    }
}

