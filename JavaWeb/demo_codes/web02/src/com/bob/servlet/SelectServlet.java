package com.bob.servlet;

import com.bob.bean.Student;
import com.bob.service.StudentService;
import com.bob.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


//处理请求的过程:

//请求->servlet->调取service(业务逻辑代码)->调取Dao(持久化)层->db(mysql)

//MVC       M-javabean(bean,dao,dao.impl,(service)）       V- jsp,html     C-servlet,(service)
@WebServlet(urlPatterns = {"/select"})
public class SelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数

        //调取逻辑方法
        StudentService studentService = new StudentServiceImpl();
        List<Student> getall = null;
        try {
            getall = studentService.getall();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //跳转页面
        req.setAttribute("stulist",getall);
        req.getRequestDispatcher("show.jsp").forward(req,resp);

    }
}
