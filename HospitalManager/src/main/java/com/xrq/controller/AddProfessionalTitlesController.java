package com.xrq.controller;/**
 * @author 许瑞琪
 * Date  2025/7/10 9:59
 */

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

@WebServlet("/manage/addProfessionalTitles.do")
public class AddProfessionalTitlesController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收请求中科室的信息

        String professionTitles = request.getParameter("professionTitles");
        //Integer professionTitlesId = Integer.parseInt(request.getParameter("professionTitlesId"));
        String professionTitlesDescription = request.getParameter("professionTitlesDescription");
        //把数据封装到Department对象
        ProfessionalTitles professionalTitles = new ProfessionalTitles();
        professionalTitles.setTitleName(professionTitles);
        //professionalTitles.setId(professionTitlesId);
        professionalTitles.setDescription(professionTitlesDescription);

        //调用service中添加方法
        ProfessionalTitlesService professionalTitlesService = new ProfessionalTitlesServiceImpl();
        professionalTitlesService.addProfessionalTitles(professionalTitles);

        //跳转到查询职称的控制器
        response.sendRedirect(request.getContextPath()+"/manage/selectProfessionalTitles.do");

    }
}
