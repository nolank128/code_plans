package com.project.smart_campus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.project.smart_campus.pojo.Clazz;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/27/22:08
 */

public interface ClazzService extends IService<Clazz> {
    IPage<Clazz> getClazzByOpr(Page<Clazz> page, Clazz clazz);

    List<Clazz> getClazzs();
}
