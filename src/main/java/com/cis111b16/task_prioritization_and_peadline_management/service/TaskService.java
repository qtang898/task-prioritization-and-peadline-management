package com.cis111b16.task_prioritization_and_peadline_management.service;

import com.cis111b16.task_prioritization_and_peadline_management.DTOs.TaskAddDto;
import com.cis111b16.task_prioritization_and_peadline_management.DTOs.TaskDto;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> showAll();

    List<Task> add(TaskAddDto taskAddDto);

    List<Task> edit(TaskDto task);

    Task findByID(int id);

    List<Task> findByTitle(String title);
}
