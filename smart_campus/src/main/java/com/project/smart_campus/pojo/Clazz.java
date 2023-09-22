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
 * @Date: 2023/07/27/21:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_clazz")
public class Clazz {

    //主键 ,自动判断类型
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String name;
    private int number;
    private String introducation;
    private String headmaster;
    private String email;
    private String telephone;
    private String gradeName;

}
