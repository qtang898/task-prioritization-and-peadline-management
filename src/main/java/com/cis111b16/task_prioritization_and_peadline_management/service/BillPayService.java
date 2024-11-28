package com.cis111b16.task_prioritization_and_peadline_management.service;

import com.cis111b16.task_prioritization_and_peadline_management.model.entity.BillPay;

public interface BillPayService {
    BillPay findByID(int taskid);

    BillPay edit(BillPay billPay);
}
