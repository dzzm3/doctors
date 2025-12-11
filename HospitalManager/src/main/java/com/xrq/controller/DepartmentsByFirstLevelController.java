package com.xrq.controller;/**
 * @author 许瑞琪
 * Date  2025/7/8 15:56
 */

import com.github.pagehelper.PageInfo;
import com.xrq.mapper.ProfessionalTitlesMapper;
import com.xrq.pojo.Departments;
import com.xrq.pojo.ProfessionalTitles;
import com.xrq.service.DepartmentsService;
import com.xrq.service.Impl.DepartmentsServiceImpl;
import com.xrq.service.Impl.ProfessionalTitlesServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/manage/departmentByFirst.do")  //此资源需要登录后可访问，因此设置路径时多一级/manage
public class DepartmentsByFirstLevelController extends HttpServlet {
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
        DepartmentsServiceImpl departmentsService = new DepartmentsServiceImpl();
        PageInfo<Departments> pageInfo=departmentsService.getDepartments(pageNum, pageSize);
        //使用request对象，存储pageInfo值
        request.setAttribute("pageInfo", pageInfo);
        //页面跳转到职称列表页面
        request.getRequestDispatcher("/manage/departmentList.jsp").forward(request, response);
    }
}
