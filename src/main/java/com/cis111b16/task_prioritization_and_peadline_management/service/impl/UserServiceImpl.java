package com.cis111b16.task_prioritization_and_peadline_management.service.impl;

import com.cis111b16.task_prioritization_and_peadline_management.DTOs.UserRegisterDto;
import com.cis111b16.task_prioritization_and_peadline_management.mapper.UserMapper;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.User;
import com.cis111b16.task_prioritization_and_peadline_management.service.UserService;
import com.cis111b16.task_prioritization_and_peadline_management.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUserName(String username) {
        User u= userMapper.findByUserName(username);
        return u;
    }

    @Override
    public void register(UserRegisterDto registerDto) {
        String md5String= MD5Utils.encrypt(registerDto.getPassword());
        registerDto.setPassword(md5String);
        userMapper.add(registerDto);
    }
}
