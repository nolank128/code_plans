package com.bob.web;

import com.bob.bean.Users;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/getUserById"})
public class GetUserByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数
        String uId = req.getParameter("uId");
        //查询
        Users u= null;
        switch (uId){
            case "1":
                u=new Users(1,"Bob","男");
                break;
            case "2":
                u=new Users(2,"Bob2","男");
                break;
            case "3":
                u=new Users(3,"Bob3","男");
                break;
            case "4":
                u=new Users(4,"Bob4","男");
                break;
        }
        //返回数据给前端
        JSONObject jsonObject = JSONObject.fromObject(u);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println(jsonObject);
    }
}
