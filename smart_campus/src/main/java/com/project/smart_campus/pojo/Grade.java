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
 * @Date: 2023/07/27/21:42
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_grade")
public class Grade {
    //主键 ,自动判断类型
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String name;
    private String manager;
    private String email;
    private String telephone;
    private String introducation;


}
