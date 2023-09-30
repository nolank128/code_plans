package com.bob;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="servlet3",urlPatterns = {"/testservlet3"},initParams = {
        @WebInitParam(name = "mya1",value = "myinit"),
        @WebInitParam(name = "mya2",value = "myinit-2")
},loadOnStartup = 1)
public class MyServlet3 extends HttpServlet {

    public MyServlet3() {
        System.out.println("myservlet3()");
    }
    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Destroy()");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("myservlet3-init-param="+config.getInitParameter("mya1"));
        System.out.println("myservlet3-init-param="+config.getInitParameter("mya2"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println("doget-myservlet3");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        System.out.println("dopost-myservlet3");

    }
}
