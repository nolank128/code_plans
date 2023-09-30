package com.bob.web;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.sun.org.apache.xalan.internal.xsltc.trax.SmartTransformerFactoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;
import java.io.IOException;

@WebServlet(urlPatterns = {"/ToUpload"})
public class UpLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //1.创建对象
            SmartUpload smartUpload = new SmartUpload();
            //2.初始化
            JspFactory defaultFactory = JspFactory.getDefaultFactory();
            PageContext pageContext = defaultFactory.getPageContext(this,req,resp,null,false,1024,true);

            smartUpload.initialize(pageContext);
            smartUpload.setCharset("utf-8");
            //3.上传
            smartUpload.upload();
            //4.指定上传路径
            File file = smartUpload.getFiles().getFile(0);
            String fileName = file.getFileName();
            //5.生成路径
            String url = "/MyUploadFile/"+fileName;
            //6.文件保存
            file.saveAs(url,File.SAVEAS_VIRTUAL);
            //7.得到上传的普通文本
            String uName = smartUpload.getRequest().getParameter("uName");
            //8.跳转页面
            req.setAttribute("userName",uName);
            req.setAttribute("imgName",fileName);
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        }catch (SmartUploadException e){
            e.printStackTrace();
        }


    }
}
