package com.cis111b16.task_prioritization_and_peadline_management.mapper;

import com.cis111b16.task_prioritization_and_peadline_management.DTOs.TaskAddDto;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.Homework;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * The interface Homework mapper.
 */
@Mapper
public interface HomeworkMapper {
    /**
     * Add int.
     *
     * @param taskAddDto the task add dto
     * @return the int
     */
    @Insert("INSERT INTO Homeworks(TaskID,Subject,Notes, Pages, TeacherNotes, AssignmentType, DueDate) VALUES " +
            "(#{id},#{subject},#{notes},#{pages},#{teachernotes},#{assignmenttype},#{duedate})")
    int add(TaskAddDto taskAddDto);

    /**
     * Find by id homework.
     *
     * @param taskid the taskid
     * @return the homework
     */
    @Select("SELECT * FROM `Homeworks` WHERE `TaskID`=#{taskid};")
    Homework findByID(int taskid);

    /**
     * Edit.
     *
     * @param homework the homework
     */
    @Update("UPDATE `Homeworks` SET " +
            "`Subject`=#{subject}," +
            "`Notes`=#{notes}," +
            "`Pages`=#{pages}," +
            "`TeacherNotes`=#{teacherNotes}," +
            "`AssignmentType`=#{assignmentType}," +
            "`DueDate`=#{dueDate} " +
            " WHERE id = #{id}")
    void edit(Homework homework);

}
