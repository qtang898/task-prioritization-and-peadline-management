package com.cis111b16.task_prioritization_and_peadline_management.mapper;

import com.cis111b16.task_prioritization_and_peadline_management.DTOs.TaskAddDto;
import com.cis111b16.task_prioritization_and_peadline_management.DTOs.TaskDto;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.Task;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The interface Task mapper.
 */
@Mapper
public interface TaskMapper {
    /**
     * Add int.
     *
     * @param taskAddDto the task add dto
     * @return the int
     */
    @Insert("INSERT INTO Tasks (TaskTitle, Level, Type, UserID, DueDate, Status) " +
            "VALUES (#{tasktitle},#{level},#{type},#{userid},#{duedate},#{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int add(TaskAddDto taskAddDto);

    /**
     * All tasks list.
     *
     * @return the list
     */
    @Select("Select * from Tasks order by duedate desc, level desc ")
    List<Task> allTasks();

    /**
     * Edit int.
     *
     * @param taskDto the task dto
     * @return the int
     */
    @Update("UPDATE Tasks SET TaskTitle=#{tasktitle},Level=#{level},Type=#{type},DueDate=#{duedate},Status=#{status} WHERE id=#{id}")
    int edit(TaskDto taskDto);

}
