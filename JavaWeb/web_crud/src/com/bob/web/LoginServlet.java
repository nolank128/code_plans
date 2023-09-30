package com.bob.web;

import com.bob.bean.Users;
import com.bob.service.UsersService;
import com.bob.service.impl.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/tologin"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数
        String uname = req.getParameter("uname");
        String upass = req.getParameter("upass");

        //调取方法
        UsersService usersService = new UsersServiceImpl();
        Users users = usersService.login(uname, upass);
        //跳转页面
        if(users==null){
            resp.sendRedirect("/login.jsp");
        }else{
            req.getSession().setAttribute("u1",users);
            resp.sendRedirect("/index.jsp");
        }
    }
}
