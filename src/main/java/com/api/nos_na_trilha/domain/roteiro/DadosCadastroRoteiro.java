package com.api.nos_na_trilha.domain.roteiro;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record DadosCadastroRoteiro(
        Long idParceiro,
        @NotBlank
        String nome,
        Long preco,
        int qtdVagas,
        Date dataInicio,
        @NotBlank
        String horarioSaida,
        @NotBlank
        String transporte,
        String categoria,
        String alojamento,
        String descricao,
        String requisitos,
        String atracoesAtv,
        String ufSaida,
        String cidadeSaida,
        String numeroContato
) {
}
