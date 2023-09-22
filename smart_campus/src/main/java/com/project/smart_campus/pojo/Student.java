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
 * @Date: 2023/07/27/21:46
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_student")
public class Student {

    //主键 ,自动判断类型
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String sno;
    private String name;
    private String gender;
    private String password;
    private String email;
    private String telephone;
    private String address;
    private String introducation;
    private String portraitPath;
    private String clazzName;

}
