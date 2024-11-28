package com.cis111b16.task_prioritization_and_peadline_management.service.impl;

import com.cis111b16.task_prioritization_and_peadline_management.mapper.HomeworkMapper;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.Homework;
import com.cis111b16.task_prioritization_and_peadline_management.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeworkServiceImpl implements HomeworkService {

    @Autowired
    private HomeworkMapper homeworkMapper;

    @Override
    public Homework findByID(int taskid) {
        return homeworkMapper.findByID(taskid);
    }

    @Override
    public Homework edit(Homework homework) {
        homeworkMapper.edit(homework);
        return homework;
    }
}
