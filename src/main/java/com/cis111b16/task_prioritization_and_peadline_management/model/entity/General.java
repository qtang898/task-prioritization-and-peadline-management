package com.cis111b16.task_prioritization_and_peadline_management.model.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * The type General.
 */
@Data
public class General {
    private int id;
    private int taskID;
    private String notes;
    private LocalDateTime dueDate;
}
