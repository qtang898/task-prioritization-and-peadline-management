package com.cis111b16.task_prioritization_and_peadline_management.controller;

import com.cis111b16.task_prioritization_and_peadline_management.mapper.BillPayMapper;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.BillPay;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.Result;
import com.cis111b16.task_prioritization_and_peadline_management.service.BillPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/billpay")
@Validated
public class BillPayController {

    @Autowired
    private BillPayService billPayService;

    @GetMapping("/findbyid/{taskid}")
    public Result<BillPay> findByID(@PathVariable int taskid){
        //if
        BillPay billPay=billPayService.findByID(taskid);
        //if
        return  Result.success(billPay);
    }
    @PostMapping("/edit")
    public Result<BillPay> edit(@RequestBody BillPay billPay){
        //if
        BillPay b=billPayService.edit(billPay);
        //if
        return  Result.success(b);
    }
}
