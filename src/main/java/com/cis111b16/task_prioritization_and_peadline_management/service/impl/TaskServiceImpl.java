package com.cis111b16.task_prioritization_and_peadline_management.service.impl;

import com.cis111b16.task_prioritization_and_peadline_management.DTOs.TaskAddDto;
import com.cis111b16.task_prioritization_and_peadline_management.DTOs.TaskDto;
import com.cis111b16.task_prioritization_and_peadline_management.mapper.BillPayMapper;
import com.cis111b16.task_prioritization_and_peadline_management.mapper.GeneralMapper;
import com.cis111b16.task_prioritization_and_peadline_management.mapper.HomeworkMapper;
import com.cis111b16.task_prioritization_and_peadline_management.mapper.TaskMapper;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.Task;
import com.cis111b16.task_prioritization_and_peadline_management.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private BillPayMapper billPayMapper;
    @Autowired
    private HomeworkMapper homeworkMapper;
    @Autowired
    private GeneralMapper generalMapper;

    @Override
    public List<Task> showAll() {
        return taskMapper.allTasks();
    }

    @Override
    public List<Task> add(TaskAddDto taskAddDto) {

        taskMapper.add(taskAddDto);

        switch (taskAddDto.getType()){
            case "billpay":
                billPayMapper.add(taskAddDto);
                break;
            case "homework":
                homeworkMapper.add(taskAddDto);
                break;
            default:
                //general
                generalMapper.add(taskAddDto);
        }

        return this.showAll();
    }

    @Override
    public List<Task> edit(TaskDto task) {
        taskMapper.edit(task);
        return showAll();
    }

    @Override
    public Task findByID(int id) {
        Optional<Task> task=showAll().stream()
                .filter(t->t.getId().equals(id))
                .findFirst();

        return task.orElse(null);
    }

    @Override
    public List<Task> findByTitle(String title) {
        return   showAll().stream()
                .filter(t->t.getTaskTitle()!=null && t.getTaskTitle().contains(title))
                .collect(Collectors.toList());
    }
}
