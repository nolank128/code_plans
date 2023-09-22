package dao;

import org.springframework.web.servlet.tags.BindTag;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/11/17:45
 */
public class User {

    private String name;
    private int age;
    private String gender;


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
