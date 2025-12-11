package com.xrq.controller;/**
 * @author 许瑞琪
 * Date  2025/7/9 10:45
 */

import com.xrq.pojo.Departments;
import com.xrq.service.DepartmentsService;
import com.xrq.service.Impl.DepartmentsServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/manage/addDepartment.do")
public class DepartmentAddController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收请求中科室的信息
        String departmentName = request.getParameter("departmentName");
        Integer departmentPid = Integer.parseInt(request.getParameter("departmentPid"));
        Integer departmentLevel = Integer.parseInt(request.getParameter("departmentLevel"));
        String departmentDescription = request.getParameter("departmentDescription");
        //把数据封装到Department对象
        Departments department = new Departments();
        department.setDepartmentName(departmentName);
        department.setDepartmentPid(departmentPid);
        department.setDepartmentLevel(departmentLevel);
        department.setDepartmentDescription(departmentDescription);

        //调用service中添加方法
        DepartmentsService departmentsService = new DepartmentsServiceImpl();
        departmentsService.addDepartment(department);
        //跳转到查询科室的控制器
        response.sendRedirect(request.getContextPath()+"/manage/departmentByFirst.do");


    }
}
