package com.xrq.controller;/**
 * @author 许瑞琪
 * Date  2025/7/9 16:13
 * 多条件*分页查询医生的控制器
 */

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xrq.pojo.Doctors;
import com.xrq.service.DoctorService;
import com.xrq.service.Impl.DoctorServiceImpl;
import com.xrq.vo.DoctorSearchVo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/manage/doctorsSearch.do")
public class DoctorsSearchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //1 接收页码
        Integer pageSize = 5;
        Integer pageNum = 1;
        String page=request.getParameter("page");
        if(page!=null&& page.length()>0){
            pageNum = Integer.parseInt(page);
        }
        //2 接收查询条件

        //科室
        Integer departmentId=null;
        String strDepartmentId=request.getParameter("departmentId");
        if(strDepartmentId!=null&&strDepartmentId.length()>0){
            departmentId=Integer.parseInt(strDepartmentId);
        }
//职称
        Integer titleId=null;
        String strTitleId=request.getParameter("titleId");
        if(strTitleId!=null&&strTitleId.length()>0){
            titleId=Integer.parseInt(strTitleId);
        }
//职工号
        String jobNumber=request.getParameter("jobNumber");
//姓名
        String doctorName=request.getParameter("doctorName");



//封装到DoctorSearchVo
        DoctorSearchVo searchVo = new DoctorSearchVo(departmentId, titleId, doctorName, jobNumber);

//3 创建service对象，并调用查询方法
        DoctorService doctorService= new DoctorServiceImpl();
        PageInfo<Doctors> pageInfo=doctorService.getDoctorsByPageAndSearch(searchVo, pageNum, pageSize);
//4 使用request
        request.setAttribute("pageInfo", pageInfo);
//5 转到显示所有医生页面
        request.getRequestDispatcher("/manage/doctorList.jsp").forward(request, response);



    }
}
