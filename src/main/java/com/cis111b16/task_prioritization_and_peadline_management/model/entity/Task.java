package com.cis111b16.task_prioritization_and_peadline_management.model.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The type Task.
 */
@Data
public class Task {
    private Integer id;
    private String taskTitle;
    private int level;
    private String type;
    private int userID;
    private LocalDateTime assigneDate;
    private LocalDateTime dueDate;
    private String status;

    private List<General> generals;
    private List<Homework> homeworks;
    private List<BillPay> billPays;
}
