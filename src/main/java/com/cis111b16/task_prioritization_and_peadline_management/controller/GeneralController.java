package com.cis111b16.task_prioritization_and_peadline_management.controller;

import com.cis111b16.task_prioritization_and_peadline_management.model.entity.General;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.Result;
import com.cis111b16.task_prioritization_and_peadline_management.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * The type General controller.
 */
@RestController
@RequestMapping("/general")
@Validated
public class GeneralController {

    @Autowired
    private GeneralService  generalService;

    /**
     * Find by id result.
     *
     * @param taskid the taskid
     * @return the result
     */
    @GetMapping("/findbyid/{taskid}")
    public Result<General> findByID(@PathVariable int taskid){
        General g= generalService.findByID(taskid);
        if (g!=null)
            return  Result.success(g);
        return Result.error("no data");
    }

    /**
     * Edit result.
     *
     * @param general the general
     * @return the result
     */
    @PostMapping("edit")
    public Result<General> edit(@RequestBody General general){
        General g=generalService.edit(general);
        return Result.success(g);
    }
}
