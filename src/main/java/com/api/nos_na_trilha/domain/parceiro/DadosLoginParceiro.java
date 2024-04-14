package com.api.nos_na_trilha.domain.parceiro;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosLoginParceiro(
        @Email
        @NotBlank
        String email,
        @NotBlank
        String senha
) {
}
