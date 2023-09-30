package com.bob.service.impl;

import com.bob.bean.Grade;
import com.bob.dao.GradeDao;
import com.bob.dao.impl.GradeDaoImpl;
import com.bob.service.GradeService;

import java.util.List;

public class GradeServiceImpl implements GradeService {
    private GradeDao gradeDao = new GradeDaoImpl();
    @Override
    public List<Grade> getGrades() {
        return gradeDao.getGrades();
    }
}
