package com.hng_level_two_task.utils;

import com.hng_level_two_task.data.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApiResponse> exceptionHandler(Exception  exception){

        return ResponseEntity.badRequest().body(new ApiResponse(exception.getMessage(), false));
    }

}
