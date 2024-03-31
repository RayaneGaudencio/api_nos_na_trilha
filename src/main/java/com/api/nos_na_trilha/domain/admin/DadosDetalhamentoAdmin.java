package com.api.nos_na_trilha.domain.admin;

public record DadosDetalhamentoAdmin(

        Long id,
        String nome,
        String email,
        String numeroTelefone
) {
    public DadosDetalhamentoAdmin(Admin admin) {
        this(admin.getId(), admin.getNome(), admin.getEmail(), admin.getNumeroTelefone());
    }
}