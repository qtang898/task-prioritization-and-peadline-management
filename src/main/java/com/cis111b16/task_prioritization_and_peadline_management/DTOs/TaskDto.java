package com.cis111b16.task_prioritization_and_peadline_management.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * The type Task dto.
 */
@Data
public class TaskDto {
    private Integer id;
    private String tasktitle;
    private int level;
    private String type;
    private int userid;
    @JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss", timezone = "UTC")
    private LocalDateTime assignedate;
    @JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss", timezone = "UTC")
    private LocalDateTime duedate;
    private String status;
}
