package com.bob.dao.impl;

import com.bob.bean.Student;
import com.bob.dao.StudentDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bob?serverTimezone=UTC&useSSL=false";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "1234";

    @Override
    public List<Student> getall() throws SQLException {
        List<Student> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 建立连接
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            preparedStatement = connection.prepareStatement("select * from stutest");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int stuid = resultSet.getInt("stuid");
                String stuname = resultSet.getString("stuname");
                int age = resultSet.getInt("age");
                int sex = resultSet.getInt("sex");

                Student student = new Student();
                student.setStuId(stuid);
                student.setStuName(stuname);
                student.setAge(age);
                student.setSex(sex);

                list.add(student);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return list;
    }
}