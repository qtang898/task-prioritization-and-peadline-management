package com.cis111b16.task_prioritization_and_peadline_management.config;

import com.cis111b16.task_prioritization_and_peadline_management.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The type Web config.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //Set a path that is not intercepted.
        // That is, the loginInterceptor interceptor logic will not be executed when the path is requested.
        registry.addInterceptor(loginInterceptor).excludePathPatterns("/user/login","/user/register","/task/list");
    }

    //It is planned to solve React CORS interception
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("*/**")
                .allowedOrigins("http://localhost:5174","http://127.0.0.1:5174")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
