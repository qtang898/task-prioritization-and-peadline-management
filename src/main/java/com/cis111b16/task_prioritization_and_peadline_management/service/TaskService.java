package com.cis111b16.task_prioritization_and_peadline_management.service;

import com.cis111b16.task_prioritization_and_peadline_management.DTOs.TaskAddDto;
import com.cis111b16.task_prioritization_and_peadline_management.DTOs.TaskDto;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.Task;

import java.util.List;

/**
 * The interface Task service.
 */
public interface TaskService {
    /**
     * Show all list.
     *
     * @return the list
     */
    List<Task> showAll();

    /**
     * Add list.
     *
     * @param taskAddDto the task add dto
     * @return the list
     */
    List<Task> add(TaskAddDto taskAddDto);

    /**
     * Edit list.
     *
     * @param task the task
     * @return the list
     */
    List<Task> edit(TaskDto task);

    /**
     * Find by id task.
     *
     * @param id the id
     * @return the task
     */
    Task findByID(int id);

    /**
     * Find by title list.
     *
     * @param title the title
     * @return the list
     */
    List<Task> findByTitle(String title);
}
