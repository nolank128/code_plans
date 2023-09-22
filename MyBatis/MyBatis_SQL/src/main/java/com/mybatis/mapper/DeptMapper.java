package com.mybatis.mapper;

import com.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/20/12:03
 */
public interface DeptMapper {

    /**
     * 通过分步查询查询员工以及员工所对应的部门信息
     * 分步查询第二步：通过dept_id查询员工所对应的部门
     */
    Dept getEmpAndDeptByStepTwo(@Param("id") Integer id);


    /*
    * 获取部门以及部门中所有的员工信息
    * */
    Dept getDeptAndEmp(@Param("id") Integer id);

    /**
     * 通过分步查询查询部门以及部门中所有的员工信息
     * 分步查询第一步：查询部门信息
     */
    Dept getDeptAndEmpByStepOne(@Param("id") Integer id);

}
