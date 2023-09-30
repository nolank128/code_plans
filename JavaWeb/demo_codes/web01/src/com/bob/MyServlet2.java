package com.bob;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet2 extends HttpServlet {
    public MyServlet2() {
        System.out.println("无参构造");
    }

/*    @Override
    public void init() throws ServletException {
        System.out.println("init2---------------");
    }*/

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init---------初始化参数:"+config.getInitParameter("mycode"));
        System.out.println("context-init:"+config.getServletContext().getInitParameter("mycode-all"));
    }
    /* @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service2------------------");
    }*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println("doGet---------");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost---------");

        req.setCharacterEncoding("utf-8");
        //1.接收参数
        String username = req.getParameter("username");
        String[] positions = req.getParameterValues("position");
        System.out.println(username);
        for (String position : positions) {
            System.out.println("司职："+position);
        }

        //2.跳转页面
        //req.getRequestDispatcher("success.jsp").forward(req,resp); //转发
        resp.sendRedirect("success.jsp"); //重定向

        //3.服务器端保存数据给前台使用
        req.setAttribute("username",username);
        //前端获取数据
        Object username1 = req.getAttribute("username");
    }

    @Override
    public void destroy() {
        System.out.println("destroy2--------------");
    }
}
