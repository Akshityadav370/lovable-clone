package com.lovable_clone.lovable_clone.dto.auth;

import jakarta.validation.constraints.*;

public record LoginRequest(@NotBlank @Email String email, @Size(min=4, max=50) String password) {
}
