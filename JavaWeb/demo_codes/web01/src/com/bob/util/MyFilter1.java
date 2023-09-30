package com.bob.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFilter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init---Filter1");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();//获取请求地址

        System.out.println("doFilter1---stat，uri="+uri);

        if(uri.endsWith("show.jsp")||uri.endsWith("index.jsp")){
            Object userName = request.getSession().getAttribute("userName");
            if(userName==null){
            request.getRequestDispatcher("login.jsp").forward(servletRequest,servletResponse);
            return;
            }
        }

        //调取对应的servlet  或者调取下一个Filter
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("doFilter1---end");
    }

    @Override
    public void destroy() {
        System.out.println("destroy---Filter1");
    }
}
