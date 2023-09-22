package com.project.smart_campus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.smart_campus.mapper.GradeMapper;
import com.project.smart_campus.pojo.Grade;
import com.project.smart_campus.service.GradeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/27/22:14
 */

@Service
@Transactional //事务控制
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade> implements GradeService {


    @Override
    public List<Grade> getGrades() {
       return baseMapper.selectList(null);
    }

    @Override
    public IPage<Grade> getGradeByOpr(Page<Grade> pageParam, String gradeName) {

        QueryWrapper<Grade> queryWrapper=new QueryWrapper<>();

        //判断参数是否为空
        if (!StringUtils.isEmpty(gradeName)){
            queryWrapper.like("name",gradeName);
        }
        //根据id 降序
        queryWrapper.orderByDesc("id");

        //查询的所有数据
        Page<Grade> page=baseMapper.selectPage(pageParam,queryWrapper);

        return page;
    }
}
