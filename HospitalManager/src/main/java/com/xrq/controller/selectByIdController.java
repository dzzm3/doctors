package com.xrq.controller;/**
 * @author 许瑞琪
 * Date  2025/7/10 14:51
 */

import com.xrq.pojo.ProfessionalTitles;
import com.xrq.service.Impl.ProfessionalTitlesServiceImpl;
import com.xrq.service.ProfessionalTitlesService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/manage/selectById.do")
public class selectByIdController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收请求中参数值
        Integer id = Integer.parseInt(request.getParameter("id"));
        //调用service中对应的查询学生
        ProfessionalTitlesService professionalTitlesService = new ProfessionalTitlesServiceImpl();
        ProfessionalTitles professionalTitles = professionalTitlesService.selectById(id);
        //changeTitles.jsp页面
        // 使用request存储学生对象
        request.setAttribute("professionalTitles", professionalTitles);
        request.getRequestDispatcher("/manage/changeTitles.jsp").forward(request, response);

    }

}
