package com.cis111b16.task_prioritization_and_peadline_management.controller;

import com.cis111b16.task_prioritization_and_peadline_management.DTOs.UserRegisterDto;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.Result;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.User;
import com.cis111b16.task_prioritization_and_peadline_management.service.UserService;
import com.cis111b16.task_prioritization_and_peadline_management.utils.JwtUtils;
import com.cis111b16.task_prioritization_and_peadline_management.utils.MD5Utils;
import com.cis111b16.task_prioritization_and_peadline_management.utils.ThreadLocalUtils;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * The type User controller.
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Register result.
     *
     * @param registerDto the register dto
     * @return the result
     */
    @PostMapping("/register")
    public Result register(@RequestBody UserRegisterDto registerDto){
        if (registerDto.getUsername()==null || registerDto.getUsername().length()<3 || registerDto.getUsername().length()>50)
            return Result.error("username only can be 3 to 50");

        if (registerDto.getPassword()==null || registerDto.getPassword().length()<6 || registerDto.getPassword().length() >50)
            return Result.error("password only can be 6-50");

        User u=userService.findByUserName(registerDto.getUsername());

        if (u==null){
//            userService.register(username,password);
            userService.register(registerDto);
            return  Result.success();
        }else{
            return Result.error("username already take");
        }

    }

    /**
     * Login result.
     *
     * @param username the username
     * @param password the password
     * @return the result
     */
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
//
//    @GetMapping("/userinfo")
//    public Result<User> userInfo(@RequestHeader(name="Authorization") String token){
//        Map<String, Object> map = JwtUtils.parseToken(token);
//        String username=(String) map.get("username");
//
//        User user = userService.findByUserName(username);
//        return Result.success(user);
//    }

    /**
     * User info result.
     *
     * @return the result
     */
    @GetMapping("/userinfo")
    public Result<User> userInfo(){
        Map<String,Object> map= ThreadLocalUtils.get();
        String username= (String) map.get("username");
        User user = userService.findByUserName(username);
        return Result.success(user);
    }
}
