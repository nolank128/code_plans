package com.bob.dao.impl;

import com.bob.bean.Grade;
import com.bob.dao.DBUtils;
import com.bob.dao.GradeDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeDaoImpl extends DBUtils implements GradeDao {

    @Override
    public List<Grade> getGrades() {
        List list = new ArrayList();
        try {
            String sql = "select * from grade";
            resultSet = query(sql,null);
            while (resultSet.next()){
                Grade grade = new Grade();
                grade.setGradeId(resultSet.getInt("gradeid"));
                grade.setGradeName(resultSet.getString("gradename"));
                list.add(grade);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }
        return list;
    }
}
