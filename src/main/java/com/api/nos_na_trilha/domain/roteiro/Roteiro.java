package com.api.nos_na_trilha.domain.roteiro;

import com.api.nos_na_trilha.domain.parceiro.Parceiro;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "roteiros")
@Entity(name = "Roteiro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Roteiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Long preco;
    private int qtdVagas;
    private Date dataInicio;
    private String horarioSaida;
    private String transporte;
    private CategoriaRoteiro categoria;
    private String alojamento;
    private String descricao;
    private String requisitos;
    private String atracoesAtv;
    private String ufSaida;
    private String cidadeSaida;

    private Long idParceiro;


    public Roteiro(DadosCadastroRoteiro dados) {
        this.nome = dados.nome();
        this.preco = dados.preco();
        this.qtdVagas = dados.qtdVagas();
        this.dataInicio = dados.dataInicio();
        this.horarioSaida = dados.horarioSaida();
        this.transporte = dados.transporte();
        this.categoria = dados.categoria();
        this.alojamento = dados.alojamento();
        this.descricao = dados.descricao();
        this.requisitos = dados.requisitos();
        this.atracoesAtv = dados.atracoesAtv();
        this.cidadeSaida = dados.cidadeSaida();
        this.ufSaida = dados.ufSaida();
    }
}
