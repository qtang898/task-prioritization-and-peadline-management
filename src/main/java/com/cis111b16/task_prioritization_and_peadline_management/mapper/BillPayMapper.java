package com.cis111b16.task_prioritization_and_peadline_management.mapper;

import com.cis111b16.task_prioritization_and_peadline_management.DTOs.TaskAddDto;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.BillPay;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * The interface Bill pay mapper.
 */
@Mapper
public interface BillPayMapper {
    /**
     * Add int.
     *
     * @param taskAddDto the task add dto
     * @return the int
     */
    @Insert("INSERT INTO `BillPays`(`TaskID`, `Subject`, `Notes`, `Amount`, `Payee`, `BillType`, `PaymentDueDate`) VALUES " +
            "(#{id},#{subject},#{notes},#{amount},#{payee},#{billtype},#{paymentduedate})")
    int add(TaskAddDto taskAddDto);

    /**
     * Find by id bill pay.
     *
     * @param taskid the taskid
     * @return the bill pay
     */
    @Select("SELECT * FROM `BillPays` WHERE `TaskID`=#{taskid}")
    BillPay findByID(int taskid);

    /**
     * Edit.
     *
     * @param billPay the bill pay
     */
    @Update("UPDATE `BillPays` SET " +
            "`Subject`=#{subject}," +
            "`Notes`=#{notes}," +
            "`Amount`=#{amount}," +
            "`Payee`=#{payee}," +
            "`BillType`=#{billType}," +
            "`PaymentDueDate`=#{paymentDueDate} " +
            " WHERE id=#{id}")
    void edit(BillPay billPay);
}
