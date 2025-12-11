package com.xrq.controller;
/**
 * @author 许瑞琪
 * Date  2025/7/8 11:06
 */

import com.xrq.pojo.Admins;
import com.xrq.service.AdminsService;
import com.xrq.service.Impl.AdminsServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/login.do")
public class AdminsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求的编码格式
        request.setCharacterEncoding("utf-8");
        //接收请求的中相关数据
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        Integer rid = Integer.parseInt(request.getParameter("rid"));
        //创建session对象
        HttpSession session = request.getSession();

        //判断用户角色
        if (rid==1){  //如果为管理员，则创建AdminsService对象，并调用登录验证方法
            AdminsService adminsService=new AdminsServiceImpl();
            Admins admin=adminsService.login(username,password);
            System.out.println("admin----->"+admin);
            //成功，转到管理页面
            if (admin!=null){
                //使用session对象，存储管理员信息
                session.setAttribute("admin",admin);
                response.sendRedirect(request.getContextPath()+"/manage/index.jsp");
            }
            //失败，转回登录页面
            else{
                session.setAttribute("loginErr","用户名或密码错误");
                //从web文件夹后开始写
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }

        }
        else{

            //如果为医生，则创建DoctorService对象，并调用登录验证方法

            //成功，则转到医生页面

            //失败，则转回到登录页面
        }

    }
}
