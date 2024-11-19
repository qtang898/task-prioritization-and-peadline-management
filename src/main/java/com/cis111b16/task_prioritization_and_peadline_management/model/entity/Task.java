package com.cis111b16.task_prioritization_and_peadline_management.model.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Task {
    private int id;
    private String taskTitle;
    private int level;
    private String type;
    private int userID;
    private LocalDateTime assigneDate;
    private LocalDateTime dueDate;
    private String status;
}
