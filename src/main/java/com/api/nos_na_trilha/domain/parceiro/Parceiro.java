package com.api.nos_na_trilha.domain.parceiro;


import com.api.nos_na_trilha.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "parceiros")
@Entity(name = "Parceiro")
public class Parceiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String numeroTelefone;
    private String identificador;
    private int porte;
    private String senha;

    @OneToOne(mappedBy = "parceiro", cascade = CascadeType.ALL)
    private Endereco endereco;
    public Parceiro(DadosCadastroParceiroDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.numeroTelefone = dados.numeroTelefone();
        this.identificador = dados.identificador();
        this.senha = dados.senha();
        this.porte = dados.porte();
        this.endereco = dados.endereco();
    }

}
