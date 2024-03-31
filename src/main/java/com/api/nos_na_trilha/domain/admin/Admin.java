package com.api.nos_na_trilha.domain.admin;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "admins")
@Entity(name = "Admin")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String numeroTelefone;
    private String senha;
    public Admin(DadosCadastroAdmin dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.numeroTelefone = dados.numeroTelefone();
        this.senha = dados.senha();
    }
}
