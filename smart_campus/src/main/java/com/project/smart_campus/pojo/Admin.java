package com.project.smart_campus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/27/21:23
 */


@Data   //创建set，get方法
@AllArgsConstructor //创建有参构造方法
@NoArgsConstructor //创建无参构造方法
@TableName("tb_admin")
public class Admin {

    //主键 ,自动判断类型
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String name;
    private char gender;
    private String password;
    private String email;
    private String telephone;
    private String address;
    private String portraitPath; //头像路径
}
