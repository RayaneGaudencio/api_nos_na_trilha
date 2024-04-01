package com.api.nos_na_trilha.domain.parceiro;

public record DadosDetalhamentoParceiroDAO(
    Long id,
    String nome,
    String email,
    String identificador,
    String numeroTelefone,
    int porte,
    Long tipoAssinatura,
    String senha
) {
    public DadosDetalhamentoParceiroDAO(Parceiro parceiro) {
        this(parceiro.getId(),
                parceiro.getNome(),
                parceiro.getEmail(),
                parceiro.getIdentificador(),
                parceiro.getNumeroTelefone(),
                parceiro.getPorte(),
                parceiro.getTipoAssinatura(),
                parceiro.getSenha());
    }
}
