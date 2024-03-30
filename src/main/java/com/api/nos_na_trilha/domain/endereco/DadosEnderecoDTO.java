package com.api.nos_na_trilha.domain.endereco;

import com.api.nos_na_trilha.domain.parceiro.Parceiro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEnderecoDTO(
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        @Pattern(regexp = "\\d{8}") // digitos com 8 números
        String cep,
        @NotBlank
        String cidade,
        @NotBlank
        String uf,
        String complemento,
        String numero,
        Parceiro parceiro) {

}
