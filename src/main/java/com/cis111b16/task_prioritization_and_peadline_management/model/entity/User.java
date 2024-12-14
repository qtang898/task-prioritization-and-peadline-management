package com.cis111b16.task_prioritization_and_peadline_management.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * The type User.
 */
@Data
public class User {
    private Integer id;
    private String userName;
    @JsonIgnore
    private String password;
    private String email;
    private LocalDateTime lastLogin;
    private String firstName;
    private String lastName;
}
