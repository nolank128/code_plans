package com.bob;
import javax.servlet.*;
import java.io.IOException;

public class MyServlet implements Servlet{
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("MyServlet--初始化操作");
        System.out.println("初始化参数:"+servletConfig.getInitParameter("mycode-all"));
        System.out.println("context-init:"+servletConfig.getServletContext().getInitParameter("mycode-all"));
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service()");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("Destroy MyServlet");
    }
}
