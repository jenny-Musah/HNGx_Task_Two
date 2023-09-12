package com.hng_level_two_task.data.dto;

import lombok.Data;

@Data
public class ApiResponse {

    private Object data;
    private boolean isSuccessful;

    public ApiResponse(Object data, boolean isSuccessful){
        this.data = data;
        this.isSuccessful = isSuccessful;
    }
}
