package com.cis111b16.task_prioritization_and_peadline_management.service.impl;

import com.cis111b16.task_prioritization_and_peadline_management.mapper.BillPayMapper;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.BillPay;
import com.cis111b16.task_prioritization_and_peadline_management.service.BillPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillPayServiceImpl implements BillPayService {

    @Autowired
    private BillPayMapper billPayMapper;

    @Override
    public BillPay findByID(int taskid) {
        return billPayMapper.findByID(taskid);
    }

    @Override
    public BillPay edit(BillPay billPay) {
        billPayMapper.edit(billPay);
        return billPay;
    }
}
