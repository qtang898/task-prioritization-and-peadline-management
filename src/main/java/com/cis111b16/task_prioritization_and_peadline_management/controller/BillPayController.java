package com.cis111b16.task_prioritization_and_peadline_management.controller;

import com.cis111b16.task_prioritization_and_peadline_management.mapper.BillPayMapper;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.BillPay;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.Result;
import com.cis111b16.task_prioritization_and_peadline_management.service.BillPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * The type Bill pay controller.
 */
@RestController
@RequestMapping("/billpay")
@Validated
public class BillPayController {

    @Autowired
    private BillPayService billPayService;

    /**
     * Find by id result.
     *
     * @param taskid the taskid
     * @return the result
     */
    @GetMapping("/findbyid/{taskid}")
    public Result<BillPay> findByID(@PathVariable int taskid){
        BillPay billPay=billPayService.findByID(taskid);
        if (billPay!=null)
            return  Result.success(billPay);
        return Result.error("can't find any data!");
    }

    /**
     * Edit result.
     *
     * @param billPay the bill pay
     * @return the result
     */
    @PostMapping("/edit")
    public Result<BillPay> edit(@RequestBody BillPay billPay){
        BillPay b=billPayService.edit(billPay);
        return  Result.success(b);
    }
}
