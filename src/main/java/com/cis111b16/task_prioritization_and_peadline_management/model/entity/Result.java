package com.cis111b16.task_prioritization_and_peadline_management.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Result.
 *
 * @param <T> the type parameter
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    private Integer code;
    private String message;
    private  T data;

    /**
     * Success result.
     *
     * @param <E>  the type parameter
     * @param data the data
     * @return the result
     */
    public static <E> Result<E> success(E data){
        return new Result<>(0,"success",data);
    }

    /**
     * Success result.
     *
     * @return the result
     */
    public static Result success(){
        return new Result(0,"success",null);
    }

    /**
     * Error result.
     *
     * @param message the message
     * @return the result
     */
    public static Result error(String message){
        return new Result(1,message,null);
    }
}
