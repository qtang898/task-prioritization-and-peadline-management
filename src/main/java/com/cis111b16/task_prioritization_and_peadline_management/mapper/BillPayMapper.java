package com.cis111b16.task_prioritization_and_peadline_management.mapper;

import com.cis111b16.task_prioritization_and_peadline_management.DTOs.TaskAddDto;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.BillPay;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BillPayMapper {
    @Insert("INSERT INTO `BillPays`(`TaskID`, `Subject`, `Notes`, `Amount`, `Payee`, `BillType`, `PaymentDueDate`) VALUES " +
            "(#{id},#{subject},#{notes},#{amount},#{payee},#{billtype},#{paymentduedate})")
    int add(TaskAddDto taskAddDto);

    @Select("SELECT * FROM `BillPays` WHERE `TaskID`={#taskid}")
    BillPay findByID(int taskid);

    @Update("UPDATE `BillPays` SET " +
            "`Subject`=#{subject}," +
            "`Notes`=#{notes}," +
            "`Amount`=#{amount}," +
            "`Payee`=#{payee}," +
            "`BillType`=#{billType}," +
            "`PaymentDueDate`=#{paymentDueDate} " +
            " WHERE id={#id}")
    void edit(BillPay billPay);
}
