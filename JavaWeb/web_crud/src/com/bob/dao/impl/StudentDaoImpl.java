package com.bob.dao.impl;

import com.bob.bean.Student;
import com.bob.dao.DBUtils;
import com.bob.dao.StudentDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl extends DBUtils implements StudentDao {
    @Override
    public List<Student> getall(int pageIndex,int pageSize,String stuName,String stuNo,int sex){
        //准备一个list
        List list = new ArrayList();
        try {
            //写sql
            //String sql = "select * from student limit ?,?";
            //每页显示五条    pageSize=5 pageIndex=1,2,3,4,5
            //limit 0,5  5,5  10,5
            //limit (pageIndex-1)*pageSize,pageSize

            //动态sql用StringBuffer
            StringBuffer dynamicSql = new StringBuffer("select * from student where 1=1 ");
            if(stuName!=null&&stuName.length()>0){
                dynamicSql.append(" and stuname like ? ");
            }
            if(stuNo!=null&&stuNo.length()>0){
                dynamicSql.append(" and stuno=? ");
            }
            if(sex!=-1){
                dynamicSql.append(" and sex=? ");
            }
            dynamicSql.append(" limit ?,?");

             List params = new ArrayList();

             //判断参数是否存在并且传参进入动态sql中
            if(stuName!=null&&stuName.length()>0){
                params.add("%"+stuName+"%");
            }
            if(stuNo!=null&&stuNo.length()>0){
                params.add(stuNo);
            }
            if(sex!=-1){
                params.add(sex);
            }

             params.add((pageIndex-1)*pageSize);
             params.add(pageSize);
            //查出来的数据放到结果集中  当用动态sql时注意要转为String类型，因为它本身是StringBuffer类型
            resultSet=query(dynamicSql.toString(),params);
            //取值
            while (resultSet.next()){
                Student student = new Student();
                student.setStuId(resultSet.getInt("stuid"));
                student.setStuNo(resultSet.getString("stuno"));
                student.setProfession(resultSet.getString("profession"));
                student.setRegDate(resultSet.getDate("regdate"));
                student.setRegistered(resultSet.getString("registered"));
                student.setStuName(resultSet.getString("stuname"));
                student.setAddress(resultSet.getString("address"));
                student.setSex(resultSet.getInt("sex"));
                student.setEmail(resultSet.getString("email"));
                student.setIdNumber(resultSet.getString("idnumber"));
                student.setIntroduction(resultSet.getString("introduction"));
                student.setPhone(resultSet.getString("phone"));
                student.setPolitics(resultSet.getString("politics"));
                list.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public int totalCount(String stuName,String stuNo,int sex) {
        int total = 0;
        try {
            StringBuffer dynamicSql = new StringBuffer("select count(*) from student where 1=1  ");
            if(stuName!=null&&stuName.length()>0){
                dynamicSql.append(" and stuname like ? ");
            }
            if(stuNo!=null&&stuNo.length()>0){
                dynamicSql.append(" and stuno=? ");
            }
            if(sex!=-1){
                dynamicSql.append(" and sex=? ");
            }

            List params = new ArrayList();
            //判断参数是否存在并且传参进入动态sql中
            if(stuName!=null&&stuName.length()>0){
                params.add("%"+stuName+"%");
            }
            if(stuNo!=null&&stuNo.length()>0){
                params.add(stuNo);
            }
            if(sex!=-1){
                params.add(sex);
            }

            //resultSet = query("select count(*) from student", null);
            resultSet = query(dynamicSql.toString(),params);
            while (resultSet.next()){
                total=resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            closeAll();
        }
        return total;
    }

    @Override
    public int insertStu(Student student) {
        int update = 0;
        try {
            //写sql
            String sql = "insert into student(stuno,stuname,gid,sex,email,phone,registered,address,politics,idnumber,profession,introduction) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            List params=new ArrayList();
            //从servlet一开始封装好了的对象中取出需要的参数
            params.add(student.getStuNo());
            params.add(student.getStuName());
            params.add(student.getGid());
            params.add(student.getSex());
            params.add(student.getEmail());
            params.add(student.getPhone());
            params.add(student.getRegistered());
            params.add(student.getAddress());
            params.add(student.getPolitics());
            params.add(student.getIdNumber());
            params.add(student.getProfession());
            params.add(student.getIntroduction());
            update = update(sql, params);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            closeAll();
        }
        return update;
    }

    @Override
    public int del(String sid) {
        int result = 0;
        try {
            String sql = "delete from student where stuno=?";
            List params = new ArrayList();
            params.add(sid);
            result = update(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }
        return result;
    }

    @Override
    public Student findbyid(String sid) {
        Student student = new Student();
        try {
            String sql = "select * from student where stuno=?";
            List params = new ArrayList();
            params.add(sid);
            resultSet = query(sql, params);
            while (resultSet.next()){
                student.setStuId(resultSet.getInt("stuid"));
                student.setStuNo(resultSet.getString("stuno"));
                student.setProfession(resultSet.getString("profession"));
                student.setRegDate(resultSet.getDate("regdate"));
                student.setRegistered(resultSet.getString("registered"));
                student.setStuName(resultSet.getString("stuname"));
                student.setAddress(resultSet.getString("address"));
                student.setSex(resultSet.getInt("sex"));
                student.setEmail(resultSet.getString("email"));
                student.setIdNumber(resultSet.getString("idnumber"));
                student.setIntroduction(resultSet.getString("introduction"));
                student.setPhone(resultSet.getString("phone"));
                student.setPolitics(resultSet.getString("politics"));
                student.setGid(resultSet.getInt("gid"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }

        return student;
    }

    @Override
    public int updateStu(Student student) {
        int result = 0;
        try {
            String sql= "update student set gid=?,stuname=?,sex=? where stuno=?";
            List params = new ArrayList();
            params.add(student.getGid());
            params.add(student.getStuName());
            params.add(student.getSex());
            params.add(student.getStuNo());
            result=update(sql,params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }
        return result;
    }
}
