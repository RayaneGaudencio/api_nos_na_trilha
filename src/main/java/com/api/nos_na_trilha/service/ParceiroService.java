package com.api.nos_na_trilha.service;

import com.api.nos_na_trilha.domain.parceiro.TipoAssinatura;

public class ParceiroService {

    public static Long definirAssinatura(TipoAssinatura tipo) {
        Long idAssinatura = null;
        if (tipo.equals(TipoAssinatura.SIMPLES)) {
            idAssinatura = 1L;
        } else if (tipo.equals(TipoAssinatura.SILVER)) {
            idAssinatura = 2L;
        } else if (tipo.equals(TipoAssinatura.GOLD)) {
            idAssinatura = 3L;
        } else {
            throw new IllegalArgumentException("Tipo de assinatura inválido: " + tipo);
        }
        return idAssinatura;
    }
}
