package com.ourfinal.Interceptor;

import com.ourfinal.DAO.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("进入过滤器");
        String path = request.getServletPath();
        User user = (User) request.getSession().getAttribute("user");
        if(user != null){
                return true;
        }else{
            response.sendRedirect(request.getContextPath()+"/pages/login.html");
            return false;
        }
    }
}
