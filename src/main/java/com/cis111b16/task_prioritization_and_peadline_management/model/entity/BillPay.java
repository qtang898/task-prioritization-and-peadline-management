package com.cis111b16.task_prioritization_and_peadline_management.model.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BillPay {
    private int id;
    private int taskID;
    private String subject;
    private String notes;
    private BigDecimal amount;
    private String payee;
    private String billType;
    private LocalDateTime paymentDueDate;
}
