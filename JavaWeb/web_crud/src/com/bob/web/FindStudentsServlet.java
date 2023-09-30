package com.bob.web;

import com.bob.bean.Student;
import com.bob.service.StudentService;
import com.bob.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/Educational/student/getstudents"})
public class FindStudentsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//设置post方式编码
        //1.接收参数    pageIndex 当前页码值
        String pageIndex = req.getParameter("pageIndex");//分页首页
        int index = pageIndex==null?1:Integer.parseInt(pageIndex);
        //获得模糊查的条件
        String stuName = req.getParameter("stuName");
        String stuNo = req.getParameter("stuNo");
        String stuSex = req.getParameter("stuSex");
        int sex = stuSex==null?-1:Integer.parseInt(stuSex);

        //2.调用方法
        StudentService studentService = new StudentServiceImpl();
        List<Student> studentList = studentService.getall(index,5,stuName,stuNo,sex);

        //得到总页数 总条数%pageSize>0?总条数/pageSize+1:总条数/pageSize
        int totalCount = studentService.totalCount(stuName,stuNo,sex);
        int totalPage = totalCount%5>0?totalCount/5+1:totalCount/5;


        //3.显示数据
        req.setAttribute("totalPage",totalPage);
        req.setAttribute("totalCount",totalCount);
        req.setAttribute("stulist",studentList);
        req.setAttribute("index",index);
        //存储模糊查条件
        req.setAttribute("sname",stuName);
        req.setAttribute("sno",stuNo);
        req.setAttribute("ssex",sex);
        //注意这里list.jsp前不能加斜杠，加了斜杠它会从web根下开始寻找而不是想要的在Educational下寻找
        req.getRequestDispatcher("list.jsp").forward(req,resp);

    }
}
