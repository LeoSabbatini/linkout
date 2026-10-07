package com.linkout.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @Size(min = 3, max = 30, message = "O username deve ter entre 3 a 30 caracteres")
        @NotBlank(message = "Username é obrigatório")
        String username,

        @Size(max = 150)
        @NotBlank(message = "Name é obrigatório")
        String name,

        @Size(max = 500)
        String bio,

        @Size(max = 150)
        @Email(message = "E-mail inválido")
        @NotBlank(message = "E-mail é obrigatório")
        String email

) {
}
