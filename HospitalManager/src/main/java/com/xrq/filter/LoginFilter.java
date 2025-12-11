package com.xrq.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 许瑞琪
 * Date  2025/7/8 14:12
 */

@WebFilter("/manage/*")   //保护manage目录下的所有资源



//创建一个过渡器
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("----------过滤器----------");
        //把ServletRequest转为HttpServletRequest对象
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //把servletResponse对象转为HttpServletResponse对象
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取session对象：HttpServletRequest中的getSession()方法
        HttpSession session = request.getSession();
        //从session中获取admin的信息
        Object obj = session.getAttribute("admin");
        //如果不为null，则放行，转到请求的目录
        if(obj!=null){
            filterChain.doFilter(servletRequest, servletResponse);  //放行

        }
        //如果为null，则重定向回login.jsp
        else{
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }
    }

    @Override
    public void destroy() {
        //Filter.super.destroy();
    }
}
