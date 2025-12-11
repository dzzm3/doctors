package com.xrq.controller;/**
 * @author 许瑞琪
 * Date  2025/7/10 10:08
 */

import com.github.pagehelper.PageInfo;
import com.xrq.pojo.Departments;
import com.xrq.pojo.ProfessionalTitles;
import com.xrq.service.DepartmentsService;
import com.xrq.service.Impl.DepartmentsServiceImpl;
import com.xrq.service.Impl.ProfessionalTitlesServiceImpl;
import com.xrq.service.ProfessionalTitlesService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/manage/selectProfessionalTitles.do")
public class SelectProfessionalTitlesController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收请求中的页码
        Integer pageNum = 1;
        Integer pageSize = 5;
        String page = request.getParameter("page");
        if (page != null&&page.length()>0) {
            pageNum = Integer.parseInt(page);
        }
        //调用DepartmentsService中分页查询的方法
        ProfessionalTitlesService professionalTitlesService = new ProfessionalTitlesServiceImpl();

        PageInfo<ProfessionalTitles> pageInfoTitles=professionalTitlesService.getProfessionalTitles(pageNum, pageSize);
        //使用request对象，存储pageInfo值
        request.setAttribute("pageInfoTitles", pageInfoTitles);
        //页面跳转到科室列表页面
        request.getRequestDispatcher("/manage/professionalTitlesList.jsp").forward(request, response);

    }
}
