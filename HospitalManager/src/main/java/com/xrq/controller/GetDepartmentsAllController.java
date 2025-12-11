package com.xrq.controller;/**
 * @author 许瑞琪
 * Date  2025/7/15 17:15
 */

import com.xrq.pojo.Departments;
import com.xrq.pojo.Doctors;
import com.xrq.service.DepartmentsService;
import com.xrq.service.DoctorService;
import com.xrq.service.Impl.DepartmentsServiceImpl;
import com.xrq.service.Impl.DoctorServiceImpl;
import com.xrq.vo.DoctorSearchVo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/homepage/getDepartmentsAll.do")
public class GetDepartmentsAllController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");



        DepartmentsService departmentsService=new DepartmentsServiceImpl();

        List<Departments> departmentsList=departmentsService.getDepartmentAll();
        request.setAttribute("departmentsList", departmentsList);


        //5 转到显示所有科室页面
        request.getRequestDispatcher("/homepage/keshi.jsp").forward(request, response);



    }
}
