package com.project.smart_campus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.smart_campus.mapper.ClazzMapper;
import com.project.smart_campus.pojo.Clazz;
import com.project.smart_campus.service.ClazzService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/27/22:13
 */


@Service("clazzServiceImpl")
@Transactional //事务控制
public class ClazzServiceImpl extends ServiceImpl<ClazzMapper, Clazz> implements ClazzService {

    @Override
    public IPage<Clazz> getClazzByOpr(Page<Clazz> page,Clazz clazz) {
        QueryWrapper<Clazz> queryWrapper=new QueryWrapper<>();
        //获取gradename属性，获取name属性
        String gradeName=clazz.getGradeName();
        if (!StringUtils.isEmpty(gradeName)){
            queryWrapper.like("grade_name",gradeName);
        }

        String name=clazz.getName();
        if (!StringUtils.isEmpty(name)){
            queryWrapper.like("name",name);
        }

        queryWrapper.orderByDesc("id");
        Page<Clazz> clazzPage=baseMapper.selectPage(page,queryWrapper);
        return clazzPage;

    }

    @Override
    public List<Clazz> getClazzs() {
        return baseMapper.selectList(null);
    }

}