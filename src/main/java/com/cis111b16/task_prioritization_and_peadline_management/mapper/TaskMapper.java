package com.cis111b16.task_prioritization_and_peadline_management.mapper;

import com.cis111b16.task_prioritization_and_peadline_management.DTOs.TaskAddDto;
import com.cis111b16.task_prioritization_and_peadline_management.DTOs.TaskDto;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.Task;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface TaskMapper {
    @Insert("INSERT INTO Tasks (TaskTitle, Level, Type, UserID, DueDate, Status) " +
            "VALUES (#{tasktitle},#{level},#{type},#{userid},#{duedate},#{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int add(TaskAddDto taskAddDto);

    @Select("Select * from Tasks order by duedate desc, level desc ")
    List<Task> allTasks();

    @Update("UPDATE Tasks SET TaskTitle=#{tasktitle},Level=#{level},Type=#{type},DueDate=#{duedate},Status=#{status} WHERE id=#{id}")
    int edit(TaskDto taskDto);

}
