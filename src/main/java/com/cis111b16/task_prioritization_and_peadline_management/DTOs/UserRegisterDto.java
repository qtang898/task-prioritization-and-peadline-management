package com.cis111b16.task_prioritization_and_peadline_management.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserRegisterDto {
    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
}
