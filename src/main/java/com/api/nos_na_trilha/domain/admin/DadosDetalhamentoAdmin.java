package com.api.nos_na_trilha.domain.admin;

public record DadosDetalhamentoAdmin (

        Long id,
        String nome,
        String email
) {
    public DadosDetalhamentoAdmin(Admin admin) {
        this(admin.getId(), admin.getNome(), admin.getEmail());
    }
}