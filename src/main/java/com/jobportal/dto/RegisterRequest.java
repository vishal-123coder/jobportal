package com.jobportal.dto;

import com.jobportal.entity.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Request payload for user registration")
public class RegisterRequest {

    @NotBlank(message = "Name is required")
    @Schema(
            description = "Full name of the user",
            example = "Vishal Kumar"
    )
    private String name;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    @Schema(
            description = "User email address",
            example = "vishal@gmail.com"
    )
    private String email;

    @Size(min = 4, message = "Password must be at least 4 characters")
    @NotBlank(message = "Password is required")
    @Schema(
            description = "User password (minimum 4 characters)",
            example = "Pass@123"
    )
    private String password;

    @NotNull(message = "Role is required")
    @Schema(
            description = "Role of the user (e.g., USER, RECRUITER)",
            example = "USER"
    )
    private Role role;
}
