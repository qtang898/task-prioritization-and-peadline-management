package com.cis111b16.task_prioritization_and_peadline_management.exception;

import ch.qos.logback.core.util.StringUtil;
import com.cis111b16.task_prioritization_and_peadline_management.model.entity.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
        e.printStackTrace();
        return Result.error(StringUtils.hasLength(e.getMessage()) ? e.getMessage():"error");
    }
}
