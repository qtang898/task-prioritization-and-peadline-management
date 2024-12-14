package com.cis111b16.task_prioritization_and_peadline_management.service;

import com.cis111b16.task_prioritization_and_peadline_management.model.entity.Homework;

/**
 * The interface Homework service.
 */
public interface HomeworkService {
    /**
     * Find by id homework.
     *
     * @param taskid the taskid
     * @return the homework
     */
    Homework findByID(int taskid);

    /**
     * Edit homework.
     *
     * @param homework the homework
     * @return the homework
     */
    Homework edit(Homework homework);
}
