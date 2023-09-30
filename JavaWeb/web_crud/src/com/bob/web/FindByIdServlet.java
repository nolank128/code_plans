package com.bob.web;

import com.bob.bean.Grade;
import com.bob.bean.Student;
import com.bob.service.GradeService;
import com.bob.service.StudentService;
import com.bob.service.impl.GradeServiceImpl;
import com.bob.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/Educational/student/findbyid"})
public class FindByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数
        String sid = req.getParameter("sid");
        //调取方法
        StudentService studentService = new StudentServiceImpl();
        Student stu = studentService.findbyid(sid);
        //跳转页面
        req.setAttribute("stu",stu);
        //查询年级列表
        GradeService gradeService = new GradeServiceImpl();
        List<Grade> grades = gradeService.getGrades();
        req.setAttribute("glist",grades);
        req.getRequestDispatcher("edit.jsp").forward(req,resp);
    }
}
