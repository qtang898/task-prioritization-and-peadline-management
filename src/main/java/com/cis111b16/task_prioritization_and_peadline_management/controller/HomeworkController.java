package com.cis111b16.task_prioritization_and_peadline_management.controller;

import com.cis111b16.task_prioritization_and_peadline_management.model.entity.Homework;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.Result;
import com.cis111b16.task_prioritization_and_peadline_management.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * The type Homework controller.
 */
@RestController
@RequestMapping("/homework")
@Validated
public class HomeworkController {

    @Autowired
    private HomeworkService homeworkService;

    /**
     * Findbyid result.
     *
     * @param taskid the taskid
     * @return the result
     */
    @GetMapping("findbyid/{taskid}")
    public Result<Homework> findbyid(@PathVariable int taskid){
        Homework homework = homeworkService.findByID(taskid);
        if (homework!=null)
            return  Result.success(homework);
        return Result.error("Data no found!");
    }

    /**
     * Edit result.
     *
     * @param homework the homework
     * @return the result
     */
    @PostMapping("/edit")
    public Result<Homework> edit(@RequestBody Homework homework){
        Homework h=homeworkService.edit(homework);
        //need some if here lol
        return Result.success(h);
    }
}
