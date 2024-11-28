package com.cis111b16.task_prioritization_and_peadline_management.controller;

import com.cis111b16.task_prioritization_and_peadline_management.DTOs.TaskAddDto;
import com.cis111b16.task_prioritization_and_peadline_management.DTOs.TaskDto;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.Result;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.Task;
import com.cis111b16.task_prioritization_and_peadline_management.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@Validated
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public Result<List<Task>> Add(@RequestBody TaskAddDto taskAddDto){
        List<Task> task= taskService.add(taskAddDto);
        return  Result.success(task);
    }

    @PostMapping("/edit")
    public Result<List<Task>> Edit(@RequestBody TaskDto task){
        List<Task> t= taskService.edit(task);
        return  Result.success(t);
    }

    @GetMapping("/findbyid/{id}")
    public Result<Task> FindByID(@PathVariable int id){
        Task t=taskService.findByID(id);
        return Result.success(t);
    }

    @GetMapping("/findbytitle/{title}")
    public Result<List<Task>> FindByTitle(@PathVariable String title){
        List<Task> tasks=taskService.findByTitle(title);
        return  Result.success(tasks);
    }

    @GetMapping("/list")
    public Result<List<Task>> ShowAll(){
        List<Task> tasks= taskService.showAll();
        return Result.success(tasks);
    }
}
