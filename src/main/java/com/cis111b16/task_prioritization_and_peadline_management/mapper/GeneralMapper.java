package com.cis111b16.task_prioritization_and_peadline_management.mapper;

import com.cis111b16.task_prioritization_and_peadline_management.DTOs.TaskAddDto;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.General;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * The interface General mapper.
 */
@Mapper
public interface GeneralMapper {

    /**
     * Add int.
     *
     * @param taskAddDto the task add dto
     * @return the int
     */
    @Insert("INSERT INTO Generals(TaskID, Notes, DueDate) VALUES " +
            "(#{id},#{notes},#{duedate})")
    int add(TaskAddDto taskAddDto);

    /**
     * Find by id general.
     *
     * @param taskid the taskid
     * @return the general
     */
    @Select("SELECT * FROM `Generals` WHERE `TaskID`=#{taskid}")
    General findByID(int taskid);

    /**
     * Edit.
     *
     * @param general the general
     */
    @Update("UPDATE `Generals` SET " +
                      "`Notes`=#{notes}," +
                      "`DueDate`=#{dueDate} " +
                      "WHERE id=#{id}")
    void edit (General general);
}
