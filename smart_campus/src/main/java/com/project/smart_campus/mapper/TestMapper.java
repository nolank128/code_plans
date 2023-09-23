package com.project.smart_campus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.smart_campus.pojo.Test;
import com.project.smart_campus.pojo.TestExample;
import java.util.List;
import java.util.stream.BaseStream;

import org.apache.ibatis.annotations.Param;

public interface TestMapper extends BaseMapper<Test> {

    /*
    * 测试分页
    * */
    List<Test> findPageTest(Page<Test> page);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_test
     *
     * @mbggenerated Wed Jul 26 21:23:04 CST 2023
     */
    int countByExample(TestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_test
     *
     * @mbggenerated Wed Jul 26 21:23:04 CST 2023
     */
    int deleteByExample(TestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_test
     *
     * @mbggenerated Wed Jul 26 21:23:04 CST 2023
     */
    int insert(Test record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_test
     *
     * @mbggenerated Wed Jul 26 21:23:04 CST 2023
     */
    int insertSelective(Test record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_test
     *
     * @mbggenerated Wed Jul 26 21:23:04 CST 2023
     */
    List<Test> selectByExample(TestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_test
     *
     * @mbggenerated Wed Jul 26 21:23:04 CST 2023
     */
    int updateByExampleSelective(@Param("record") Test record, @Param("example") TestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_test
     *
     * @mbggenerated Wed Jul 26 21:23:04 CST 2023
     */
    int updateByExample(@Param("record") Test record, @Param("example") TestExample example);
}