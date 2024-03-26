package com.api.nos_na_trilha.domain.admin;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosLoginAdmin(

        @Email
        @NotBlank
        String email,
        @NotBlank
        String senha
) {
}
