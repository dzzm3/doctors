package com.xrq.controller;/**
 * @author 许瑞琪
 * Date  2025/7/10 11:47
 */

import com.xrq.pojo.ProfessionalTitles;
import com.xrq.service.Impl.ProfessionalTitlesServiceImpl;
import com.xrq.service.ProfessionalTitlesService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/manage/changeTitles.do")
public class ChangeTitlesController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //接收请求中的信息
        Integer titleId= Integer.valueOf(request.getParameter("id"));
        String titleName = request.getParameter("titleName");
        String description = request.getParameter("description");

        //把数据封装到对象
        ProfessionalTitles professionalTitles = new ProfessionalTitles();
        professionalTitles.setId(titleId);
        professionalTitles.setTitleName(titleName);
        professionalTitles.setDescription(description);

        //设置service中修改方法
        ProfessionalTitlesService professionalTitlesService = new ProfessionalTitlesServiceImpl();

        professionalTitlesService.changeTitles(professionalTitles);


        //跳转到查询职称的控制器
        response.sendRedirect(request.getContextPath()+"selectProfessionalTitles.do");

    }

}
