package com.cis111b16.task_prioritization_and_peadline_management.service;

import com.cis111b16.task_prioritization_and_peadline_management.DTOs.UserRegisterDto;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.User;

/**
 * The interface User service.
 */
public interface UserService {
    /**
     * Find by user name user.
     *
     * @param username the username
     * @return the user
     */
    User findByUserName(String username);

    /**
     * Register.
     *
     * @param registerDto the register dto
     */
    void register(UserRegisterDto registerDto);
}
