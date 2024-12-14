package com.cis111b16.task_prioritization_and_peadline_management.mapper;

import com.cis111b16.task_prioritization_and_peadline_management.DTOs.UserRegisterDto;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * The interface User mapper.
 */
@Mapper
public interface UserMapper {
    /**
     * Find by user name user.
     *
     * @param username the username
     * @return the user
     */
    @Select("select * from Users where UserName=#{username}")
    User findByUserName(String username);

    /**
     * Add.
     *
     * @param registerDto the register dto
     */
    @Insert("insert into Users (UserName,Password,Email,FirstName,LastName) " +
            "values (#{username},#{password},#{email},#{firstname},#{lastname})")
    void add(UserRegisterDto registerDto);
}
