package com.cis111b16.task_prioritization_and_peadline_management.controller;

import com.cis111b16.task_prioritization_and_peadline_management.model.entity.Homework;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.Result;
import com.cis111b16.task_prioritization_and_peadline_management.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/homework")
@Validated
public class HomeworkController {

    @Autowired
    private HomeworkService homeworkService;

    @GetMapping("findbyid/{taskid}")
    public Result<Homework> findbyid(@PathVariable int taskid){
        Homework homework = homeworkService.findByID(taskid);
        // some if here
        return  Result.success(homework);
    }
    @PostMapping("/edit")
    public Result<Homework> edit(@RequestBody Homework homework){
        Homework h=homeworkService.edit(homework);
        //need some if here lol
        return Result.success(h);
    }
}
