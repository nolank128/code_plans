package com.bob;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet------");
        //1.接受用户名和密码
        String uname = req.getParameter("uname");

        String pass = req.getParameter("pass");
        if(uname!=null&&pass!=null){
            if(uname.equals("Bob")&&pass.equals("12345")){
                HttpSession session = req.getSession();
                session.setAttribute("userName",uname);//存值给前台，前台可用sessionScope.userName访问到uname
                resp.sendRedirect("success.jsp");
            }else{
                resp.sendRedirect("error.jsp");
            }
        }
    }
}
