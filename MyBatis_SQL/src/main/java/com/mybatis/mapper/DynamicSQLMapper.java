package com.mybatis.mapper;

import com.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/22/19:38
 */
public interface DynamicSQLMapper {

    /*
    * 多条件查询
    * */
    List<Emp>  getEmpByCondition(Emp emp);

    /*
    * test choose，when otherwise
    * */
    List<Emp> getEmpByChoose(Emp emp);


    /**
     * 通过数组实现批量删除
     */
    int deleteMoreByArray(@Param("eids") Integer[] eids);

    /**
     * 通过list集合实现批量添加
     */
    int insertMoreByList(@Param("emps") List<Emp> emps);

}
