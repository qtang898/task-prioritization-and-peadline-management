package com.cis111b16.task_prioritization_and_peadline_management.mapper;

import com.cis111b16.task_prioritization_and_peadline_management.DTOs.TaskAddDto;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.General;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface GeneralMapper {

    @Insert("INSERT INTO Generals(TaskID, Notes, DueDate) VALUES " +
            "(#{id},#{notes},#{duedate})")
    int add(TaskAddDto taskAddDto);

    @Select("SELECT * FROM `Generals` WHERE `TaskID`={#taskid}")
    General findByID(int taskid);

    @Update("UPDATE `Generals` SET " +
                      "`Notes`={#notes}," +
                      "`DueDate`={#dueDate} " +
                      "WHERE id={#id}")
    void edit (General general);
}
