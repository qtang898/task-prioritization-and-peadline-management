package com.cis111b16.task_prioritization_and_peadline_management.service;

import com.cis111b16.task_prioritization_and_peadline_management.model.entity.Homework;

public interface HomeworkService {
    Homework findByID(int taskid);

    Homework edit(Homework homework);
}
