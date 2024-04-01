package com.api.nos_na_trilha.domain.parceiro;

import com.api.nos_na_trilha.domain.endereco.Endereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroParceiroDTO(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String senha,
        @NotBlank
        String numeroTelefone,
        @NotBlank
        String identificador,
        @NotBlank
        int porte,
        @NotBlank
        Endereco endereco,
        @NotBlank
        TipoAssinatura tipoAssinatura
) {

}
