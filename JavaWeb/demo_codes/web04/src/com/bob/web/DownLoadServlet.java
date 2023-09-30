package com.bob.web;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(urlPatterns = {"/downLoad"})
public class DownLoadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收要下载的文件名参数
        String fileName = req.getParameter("fileName");
        String url = "/MyUploadFile/"+fileName;
        //将相应内容设置成二进制流
        resp.setContentType("application/octet-stream");
        //指定编码
        fileName = URLEncoder.encode(fileName,"UTF-8");
        //弹窗形式展示给用户
        resp.addHeader("Content-Disposition","attachment;fileName="+fileName);
        req.getRequestDispatcher(url).forward(req,resp);
        //清空缓冲区
        resp.flushBuffer();
    }


}
