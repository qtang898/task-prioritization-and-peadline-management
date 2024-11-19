package com.cis111b16.task_prioritization_and_peadline_management.model.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Homework {
    private int id;
    private int taskID;
    private String subject;
    private String notes;
    private String pages;
    private String teacherNotes;
    private String assignmentType;
    private LocalDateTime dueDate;
}
