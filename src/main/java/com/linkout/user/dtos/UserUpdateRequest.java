package com.linkout.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserUpdateRequest(
        @Size(max = 150)
        @NotBlank(message = "Name é obrigatório")
        String name,

        @Size(max = 500)
        String bio,

        @Size(max = 150)
        @Email(message = "E-mail inválido")
        @NotBlank(message = "E-mail é obrigatório")
        String email

) {}
