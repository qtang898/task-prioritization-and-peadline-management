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

/**
 * The type Task controller.
 */
@RestController
@RequestMapping("/task")
@Validated
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
     * Add result.
     *
     * @param taskAddDto the task add dto
     * @return the result
     */
    @PostMapping("/add")
    public Result<List<Task>> Add(@RequestBody TaskAddDto taskAddDto){
        List<Task> task= taskService.add(taskAddDto);
        return  Result.success(task);
    }

    /**
     * Edit result.
     *
     * @param task the task
     * @return the result
     */
    @PostMapping("/edit")
    public Result<List<Task>> Edit(@RequestBody TaskDto task){
        List<Task> t= taskService.edit(task);
        return  Result.success(t);
    }

    /**
     * Find by id result.
     *
     * @param id the id
     * @return the result
     */
    @GetMapping("/findbyid/{id}")
    public Result<Task> FindByID(@PathVariable int id){
        Task t=taskService.findByID(id);
        if (t!=null)
            return Result.success(t);
        return  Result.error("no found");
    }

    /**
     * Find by title result.
     *
     * @param title the title
     * @return the result
     */
    @GetMapping("/findbytitle/{title}")
    public Result<List<Task>> FindByTitle(@PathVariable String title){
        List<Task> tasks=taskService.findByTitle(title);
        if (!tasks.isEmpty())
            return  Result.success(tasks);
        return Result.error("no found!");
    }

    /**
     * Show all result.
     *
     * @return the result
     */
    @GetMapping("/list")
    public Result<List<Task>> ShowAll(){
        List<Task> tasks= taskService.showAll();
        if (tasks!=null)
            return Result.success(tasks);
        return  Result.error("no data");
    }
}
