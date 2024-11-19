package com.cis111b16.task_prioritization_and_peadline_management.controller;

import com.cis111b16.task_prioritization_and_peadline_management.model.entity.Result;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.User;
import com.cis111b16.task_prioritization_and_peadline_management.service.UserService;
import com.cis111b16.task_prioritization_and_peadline_management.utils.JwtUtils;
import com.cis111b16.task_prioritization_and_peadline_management.utils.MD5Utils;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(String username, String password){
        if (username==null || username.length()<3 || username.length()>50)
            return Result.error("username only can be 3 to 50");

        if (password==null || password.length()<6 || password.length() >50)
            return Result.error("password only can be 6-50");

        User u=userService.findByUserName(username);

        if (u==null){
            userService.register(username,password);
            return  Result.success();
        }else{
            return Result.error("username already take");
        }

    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "\\S{3,50}$") String username ,@Pattern(regexp = "\\S{6,50}$") String password ){
       User user=userService.findByUserName(username);

       if (user==null)
           return Result.error("wrong username");

       if (!MD5Utils.encrypt(password).equals(user.getPassword()))
           return Result.error("password no match!");

//       return Result.success("success!!");
        Map<String,Object> claims=new HashMap<>();
        claims.put("id",user.getId());
        claims.put("username",user.getUserName());
        String token= JwtUtils.genToken(claims);
        return Result.success(token);
    }
}
