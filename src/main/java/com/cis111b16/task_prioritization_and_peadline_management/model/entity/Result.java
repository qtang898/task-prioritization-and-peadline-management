package com.cis111b16.task_prioritization_and_peadline_management.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    private Integer code;
    private String message;
    private  T data;

    public static <E> Result<E> success(E data){
        return new Result<>(0,"success",data);
    }

    public static Result success(){
        return new Result(0,"success",null);
    }

    public static Result error(String message){
        return new Result(1,message,null);
    }
}
