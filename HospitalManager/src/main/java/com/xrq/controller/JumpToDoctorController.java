package com.xrq.controller;/**
 * @author 许瑞琪
 * Date  2025/7/16 11:20
 */

import com.xrq.pojo.Doctors;
import com.xrq.service.DoctorService;
import com.xrq.service.Impl.DoctorServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;


@WebServlet("/homepage/jumpToDoctor.do")
public class JumpToDoctorController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //3 创建service对象，并调用查询方法
        DoctorService doctorService= new DoctorServiceImpl();
        Doctors doctors = doctorService.selectDoctorByJobNumber(Integer.parseInt(request.getParameter("jobNumber")));

        //4 使用request
        request.setAttribute("doctors", doctors);

        //5 转到显示医生页面
        request.getRequestDispatcher("/homepage/ys.jsp").forward(request, response);

    }
}
