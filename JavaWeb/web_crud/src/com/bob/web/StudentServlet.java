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

@WebServlet(urlPatterns = {"/Educational/student"})
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");//假定一个参数，key值为method，表示传递请求目的
        if(method.equals("addstudent")){
            addstudent(req, resp);
        }else if (method.equals("delstu")){
            delstudent(req, resp);
        }
    }
    //新增学生
    protected void addstudent(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        //接收参数
        req.setCharacterEncoding("utf-8");
        String sno = req.getParameter("sno");
        String sname = req.getParameter("sname");
        String sgradeid = req.getParameter("sgradeid");
        String ssex = req.getParameter("ssex");
        String semail = req.getParameter("semail");
        String sphone = req.getParameter("sphone");
        String slocation = req.getParameter("slocation");
        String saddress = req.getParameter("saddress");
        String spolitics = req.getParameter("spolitics");
        String scardid = req.getParameter("scardid");
        String sprofession = req.getParameter("sprofession");
        String sdemo = req.getParameter("sdemo");
        //调取方法
        StudentServiceImpl studentService = new StudentServiceImpl();
        Student student = new Student();
        student.setStuNo(sno);
        student.setStuName(sname);
        student.setGid(Integer.parseInt(sgradeid));
        student.setSex(Integer.parseInt(ssex));
        student.setEmail(semail);
        student.setPhone(sphone);
        student.setRegistered(slocation);
        student.setAddress(saddress);
        student.setPolitics(spolitics);
        student.setIdNumber(scardid);
        student.setProfession(sprofession);
        student.setIntroduction(sdemo);
        int result = studentService.insertStu(student);
        //跳转页面
        if(result>0){
            //新增成功，跳转到新的请求而非页面，因为list页面需要一个stulist，如果不走servlet查到它，会报错
            resp.sendRedirect("/Educational/student/getstudents");
        }else {
            //新增失败，跳转到添加界面让用户重新添加，同样的要走添加的servlet到add.jsp，因为页面需要glist
            resp.sendRedirect("/Educational/student/getgrades");
        }
    }
    //删除学生
    protected void delstudent(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        //接收参数
        String sid = req.getParameter("sid");
        //调取方法
        StudentService studentService = new StudentServiceImpl();
        int delled = studentService.del(sid);
        //跳转（刷新）页面
        //后台给前台一个弹窗
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if(delled>0){
            writer.println("<script>alert('删除成功');location.href='/Educational/student/getstudents'</script>");
        }else{
            writer.println("<script>alert('删除失败');location.href='/Educational/student/getstudents'</script>");
        }
    }
    }

    //修改


