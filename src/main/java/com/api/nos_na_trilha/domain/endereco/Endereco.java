package com.api.nos_na_trilha.domain.endereco;

import com.api.nos_na_trilha.domain.parceiro.Parceiro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Endereco")
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parceiro_id", referencedColumnName = "id")
    private Parceiro parceiro;
    public Endereco(DadosEnderecoDTO dadosEnderecoDTO) {
        this.logradouro = dadosEnderecoDTO.logradouro();
        this.bairro = dadosEnderecoDTO.bairro();
        this.cep = dadosEnderecoDTO.cep();
        this.numero = dadosEnderecoDTO.numero();
        this.complemento = dadosEnderecoDTO.complemento();
        this.cidade = dadosEnderecoDTO.cidade();
        this.uf = dadosEnderecoDTO.uf();
        this.parceiro = dadosEnderecoDTO.parceiro();
    }

    public void atualizarInformacoes(DadosEnderecoDTO novosDados) {
        if (novosDados.logradouro() != null) {
            this.logradouro = novosDados.logradouro();
        }

        if (novosDados.bairro() != null) {
            this.bairro = novosDados.bairro();
        }

        if (novosDados.cep() != null) {
            this.cep = novosDados.cep();
        }

        if (novosDados.numero() != null) {
            this.numero = novosDados.numero();
        }

        if (novosDados.complemento() != null) {
            this.complemento = novosDados.complemento();
        }

        if (novosDados.cidade() != null) {
            this.cidade = novosDados.cidade();
        }

        if (novosDados.uf() != null) {
            this.uf = novosDados.uf();
        }
    }
}