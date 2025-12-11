package com.xrq.controller;/**
 * @author 许瑞琪
 * Date  2025/7/10 16:01
 */

import com.xrq.service.Impl.ProfessionalTitlesServiceImpl;
import com.xrq.service.ProfessionalTitlesService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/manage/DelProfessionalTitles.do")
public class DelProfessionalTitlesController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求的编码格式
        request.setCharacterEncoding("utf-8");
        //获取请求中的学号
        Integer id = Integer.parseInt(request.getParameter("id"));
        //调用service中的删除方法
        ProfessionalTitlesService studentService = new ProfessionalTitlesServiceImpl();
        studentService.delTitles(id);
        //跳转到查询学生的控制器
        response.sendRedirect(request.getContextPath() + "/manage/selectProfessionalTitles.do");

    }
}
