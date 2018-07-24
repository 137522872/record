package com.hzbl360.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        HttpSession session = request.getSession();

        //获取Session中存储的对象
        Object user = session.getAttribute("user");

        // 获取当前请求的URI
        String url = request.getRequestURI();

        // 判断Session中的对象是否为空；判断请求的URI是否为不允许过滤的URI

        if(user == null && !url.endsWith("/goods/list")/*&& !url.endsWith("login.jsp")*/){

            response.sendRedirect(request.getContextPath() + "/goods/list");
        } else {

            filterChain.doFilter(servletRequest,servletResponse);
//            response.setHeader("Cache-Control","no-store");
//            response.setDateHeader("Expires",0);
//            response.setHeader("Pragma","no-cache");
//            response.flushBuffer();
        }
    }

    @Override
    public void destroy() {

    }
}
