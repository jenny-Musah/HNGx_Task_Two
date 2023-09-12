package com.hng_level_two_task.data.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AddPersonRequest {

    @Pattern(regexp = "^[A-Za-z]+$", message = "Enter a valid name with only letters")
    private String name;
}
