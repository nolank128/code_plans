package com.bob.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/checkName"})
public class CheckNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收参数
        String userName = req.getParameter("userName");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        //2.逻辑代码
        if("admin".equals(userName)){
            //表示已被占用
            writer.print("用户名已被占用");
        }else{
            //表示可用
            writer.print("用户名可用");
        }
    }
}
