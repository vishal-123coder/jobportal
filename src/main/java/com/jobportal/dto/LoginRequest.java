package com.jobportal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "Request payload for user login")
public class LoginRequest {

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    @Schema(
            description = "Registered user email",
            example = "vishal@gmail.com"
    )
    private String email;

    @NotBlank(message = "Password is required")
    @Schema(
            description = "User password",
            example = "Pass@123"
    )
    private String password;
}
