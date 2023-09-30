package com.bob.bean;

public class Users {
    private Integer userId;
    private String userName;
    private String sex;

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public Users() {
    }

    public Users(Integer userId, String userName, String sex) {
        this.userId = userId;
        this.userName = userName;
        this.sex = sex;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
