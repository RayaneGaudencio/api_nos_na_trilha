package com.api.nos_na_trilha.domain.admin;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
public record DadosCadastroAdmin (
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        String numeroTelefone,
        @NotBlank
        String senha
) {}
