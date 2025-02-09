package com.api.nos_na_trilha.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private String mensagem;
    private int codigo;

    public ErrorResponse(String mensagem, int codigo) {
        this.mensagem = mensagem;
        this.codigo = codigo;
    }

}
