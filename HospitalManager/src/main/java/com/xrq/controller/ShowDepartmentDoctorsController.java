package com.xrq.controller;/**
 * @author 许瑞琪
 * Date  2025/7/16 14:52
 */

import com.xrq.pojo.Doctors;
import com.xrq.service.DoctorService;
import com.xrq.service.Impl.DoctorServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/homepage/showDepartmentDoctors.do")

public class ShowDepartmentDoctorsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取请求中的信息
        Integer departmentId = Integer.parseInt(request.getParameter("departmentId"));
        //调用查询方法
        DoctorService doctorService = new DoctorServiceImpl();
        List<Doctors> doctorsList=doctorService.selectDoctorByDepartmentId(departmentId);

        //跳转到控制器
        request.setAttribute("doctorsList",doctorsList);
        request.getRequestDispatcher("/homepage/keshiys.jsp").forward(request, response);

    }
}

