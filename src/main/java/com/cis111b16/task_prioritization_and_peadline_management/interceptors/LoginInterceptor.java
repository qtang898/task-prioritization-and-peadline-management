package com.cis111b16.task_prioritization_and_peadline_management.interceptors;

import com.cis111b16.task_prioritization_and_peadline_management.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        String token=request.getHeader("Authorization");
        try {
            Map<String,Object> claims= JwtUtils.parseToken(token);
            return  true;
        } catch (Exception e){
            response.setStatus(401);
            return  false;
        }
    }
}
