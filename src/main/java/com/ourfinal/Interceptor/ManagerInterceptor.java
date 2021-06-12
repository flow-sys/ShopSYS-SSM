package com.ourfinal.Interceptor;

import com.ourfinal.DAO.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManagerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String type = ((User)request.getSession().getAttribute("user")).getType();
        if("0".equals(type)){
            response.sendRedirect(request.getContextPath()+"/pages/login.html");
            return false;
        }else{
            return true;
        }
    }
}
