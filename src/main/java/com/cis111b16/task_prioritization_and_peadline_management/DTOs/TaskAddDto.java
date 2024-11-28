package com.cis111b16.task_prioritization_and_peadline_management.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TaskAddDto {
    private int id;
    private String tasktitle;
    private int level;
    private String type;
    private int userid;
    @JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss", timezone = "UTC")
    private LocalDateTime assignedate;
    @JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss", timezone = "UTC")
    private LocalDateTime duedate;
    private String status;

    private String notes;
    private String subject;
   // private String notes;
    private String pages;
    private String teachernotes;
    private String assignmenttype;
//
//    private String subject;
//    private String notes;
    private BigDecimal amount;
    private String payee;
    private String billtype;
    private LocalDateTime paymentduedate;

}
