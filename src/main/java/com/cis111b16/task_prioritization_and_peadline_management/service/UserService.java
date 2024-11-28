package com.cis111b16.task_prioritization_and_peadline_management.service;

import com.cis111b16.task_prioritization_and_peadline_management.DTOs.UserRegisterDto;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.User;

public interface UserService {
    User findByUserName(String username);

    void register(UserRegisterDto registerDto);
}
