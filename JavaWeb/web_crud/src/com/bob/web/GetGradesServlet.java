package com.bob.web;

import com.bob.bean.Grade;
import com.bob.service.GradeService;
import com.bob.service.impl.GradeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/Educational/student/getgrades"})
public class GetGradesServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数
        //调取方法 -查询年级列表
        GradeService gradeService = new GradeServiceImpl();
        List<Grade> grades = gradeService.getGrades();
        req.setAttribute("glist",grades);
        //跳转页面
        req.getRequestDispatcher("add.jsp").forward(req,resp);
    }
}
