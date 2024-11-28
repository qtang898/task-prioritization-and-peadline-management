package com.cis111b16.task_prioritization_and_peadline_management.controller;

import com.cis111b16.task_prioritization_and_peadline_management.model.entity.General;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.Result;
import com.cis111b16.task_prioritization_and_peadline_management.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/general")
@Validated
public class GeneralController {

    @Autowired
    private GeneralService  generalService;

    @GetMapping("/findbyid/{id}")
    public Result<General> findByID(@PathVariable int taskid){
        General g= generalService.findByID(taskid);
        //if
        return  Result.success(g);
    }

    @PostMapping("edit")
    public Result<General> edit(@RequestBody General general){
        //if
        General g=generalService.edit(general);
        //if
        return Result.success(g);
    }
}
