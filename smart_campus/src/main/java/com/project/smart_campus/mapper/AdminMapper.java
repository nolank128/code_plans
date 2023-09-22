package com.project.smart_campus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.smart_campus.pojo.Admin;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/27/21:56
 */


@Repository

/*
* 继承接口，基础的SQL查询语句
* */
public interface AdminMapper extends BaseMapper<Admin> {

}
