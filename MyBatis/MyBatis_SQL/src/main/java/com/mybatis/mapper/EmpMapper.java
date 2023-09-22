package com.mybatis.mapper;

import com.mybatis.pojo.Dept;
import com.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/20/12:04
 */
public interface EmpMapper {


    /*
    * 查询所有员工信息
    * */
    List<Emp> getAllEmp();

    /**
     * 查询员工以及员工所对应的部门信息
     */
    Emp getEmpAndDept(@Param("eid") Integer eid);

    /**
     * 通过分步查询查询员工以及员工所对应的部门信息
     * 分步查询第一步：查询员工信息
     */
    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);


    /**
     * 通过分步查询查询部门以及部门中所有的员工信息
     * 分步查询第二步：根据id查询员工信息
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("id") Integer id);

}
