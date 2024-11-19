package com.cis111b16.task_prioritization_and_peadline_management.mapper;

import com.cis111b16.task_prioritization_and_peadline_management.model.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from Users where UserName=#{username}")
    User findByUserName(String username);

    @Insert("insert into Users (UserName,Password) values (#{username},#{password})")
    void add(String username, String password);
}
