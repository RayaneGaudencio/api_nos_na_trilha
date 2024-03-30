package com.api.nos_na_trilha.domain.parceiro;

import com.api.nos_na_trilha.domain.endereco.DadosEnderecoDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParceiroAssociations {
    private DadosCadastroParceiroDTO parceiroDados;
    private DadosEnderecoDTO dadosEnderecoDTO;
}
