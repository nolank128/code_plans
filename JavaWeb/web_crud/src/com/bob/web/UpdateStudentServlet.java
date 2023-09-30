package com.bob.web;

import com.bob.bean.Student;
import com.bob.service.StudentService;
import com.bob.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/Educational/student/updatestu"})
public class UpdateStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数
        req.setCharacterEncoding("utf-8");
        String sno = req.getParameter("sno");
        String sname = req.getParameter("sname");
        String sgradeid = req.getParameter("sgradeid");
        String ssex = req.getParameter("ssex");
        //调取方法
        StudentService studentService = new StudentServiceImpl();
        Student student = new Student();
        student.setGid(Integer.parseInt(sgradeid));
        student.setStuName(sname);
        student.setStuNo(sno);
        student.setSex(Integer.parseInt(ssex));
        int i = studentService.updateStu(student);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if(i>0){
            writer.println("<script>alert('更新成功');location.href='/Educational/student/getstudents'</script>");
        }else{
            writer.println("<script>alert('更新失败');location.href='/Educational/student/findbyid?sid="+sno+"'</script>");
        }
    }
}
