package com.cis111b16.task_prioritization_and_peadline_management.model.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String email;
    private LocalDateTime lastLogin;
    private String firstName;
    private String lastName;
}
