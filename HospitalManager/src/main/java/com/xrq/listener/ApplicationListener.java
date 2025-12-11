package com.xrq.listener;
/**
 * @author 许瑞琪
 * Date  2025/7/9 14:38
 * 监听器：监听程序重要事件的发生
 * 监听三个作用域：request，session，servletContext
 *
 * ServletContextListener, HttpSessionListener, ServletRequestListener
 * --监听作用域生命周期
 *
 * ServletContextAttributeListener, HttpSessionAttributeListener ,ServletRequestAttributeListener
 * --监听作用域：存值setAttribute(String name,Object obj)，取值getAttribute(String name)，改变值setAttribute(String name)，移除值remove(String name)
 *
 *
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
import java.util.List;

@WebListener
public class ApplicationListener implements ServletContextListener{

    public ApplicationListener() {
    }

    @Override
    //创建Application时的监听方法
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        /* 当Servlet上下文初始化时（即Web应用部署时），此方法会被调用。 */

        //获取application对象
        ServletContext application = sce.getServletContext();

        //创建科室service和职称service对象
        DepartmentsService departmentsService=new DepartmentsServiceImpl();
        ProfessionalTitlesService titlesService=new ProfessionalTitlesServiceImpl();

        //分别调用查询方法
        List<Departments> departmentsList=departmentsService.getDepartmentBySecond();
        List<ProfessionalTitles> titlesList=titlesService.selectAll();

        //使用application存储科室与职称的信息
        application.setAttribute("departmentsList",departmentsList);
        application.setAttribute("titlesList",titlesList);


    }

    @Override
    //销毁Application时的监听方法
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }

}
