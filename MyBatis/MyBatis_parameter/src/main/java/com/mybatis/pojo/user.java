package com.mybatis.pojo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/19/12:05
 */
public class user {
    private String username;
    private String password;
    private int id;
    private String sex;
    private  int age;
    private String email;

    public user(){

    }

    public user(String username, String password, int id, String sex, int age, String email) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.sex = sex;
        this.age = age;
        this.email = email;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

