package com.xrq.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 许瑞琪
 * Date  2025/7/8 14:42
 * 编码格式过滤器
 * 给所有控制器，设置请求和响应的编码格式
 */

@WebFilter("*.do")  //此保护路径不带“/”
public class CharFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //把ServletRequest和ServletResponse转换为HttpServletRequest和HttpServletResponse
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //设置请求的编码格式
        request.setCharacterEncoding("UTF-8");
        //设置响应的编码格式
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        //放行
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        //Filter.super.destroy();
    }
}
