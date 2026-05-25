package com.jobportal.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class JobRequest {

    @NotBlank
    private String title;

    private String description;

    @NotBlank
    private String location;

    private double salary;
}
