package com.api.nos_na_trilha.service;

import com.api.nos_na_trilha.domain.admin.*;
import com.api.nos_na_trilha.domain.endereco.DadosEnderecoDTO;
import com.api.nos_na_trilha.domain.endereco.Endereco;
import com.api.nos_na_trilha.domain.parceiro.DadosCadastroParceiroDTO;
import com.api.nos_na_trilha.domain.parceiro.DadosDetalhamentoParceiroDAO;
import com.api.nos_na_trilha.domain.parceiro.Parceiro;
import com.api.nos_na_trilha.domain.parceiro.ParceiroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AuthService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ParceiroRepository parceiroRepository;

    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAdmin dados, UriComponentsBuilder uriBuilder) {
        var admin = new Admin(dados);

        adminRepository.save(admin);

        var uri = uriBuilder.path("/admin/{id}").buildAndExpand(admin.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoAdmin(admin));
    }

    public ResponseEntity login(@RequestBody @Valid DadosLoginAdmin dados) {
        var admin = adminRepository.findByEmail(dados.email());
        if (admin != null) {
            if (admin.getSenha().equals(dados.senha())) {
                return ResponseEntity.ok().build();
            } else {
                ErrorResponse errorResponse = new ErrorResponse("Senha incorreta.", HttpStatus.UNAUTHORIZED.value());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(errorResponse);
            }
        } else {
            ErrorResponse errorResponse = new ErrorResponse("Não foi possível encontrar o usuário.", HttpStatus.NOT_FOUND.value());
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorResponse);
        }
    }

    public ResponseEntity cadastrarEmpresa(DadosCadastroParceiroDTO parceiroDados, DadosEnderecoDTO dadosEnderecoDTO, UriComponentsBuilder uriBuilder) {
        var idAssinatura = ParceiroService.definirAssinatura(parceiroDados.tipoAssinatura());
        var parceiro = new Parceiro(parceiroDados);
        if (parceiroRepository.existsByEmail(parceiro.getEmail())) {
            ErrorResponse errorResponse = new ErrorResponse("Email já cadastrado.", HttpStatus.CONFLICT.value());
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(errorResponse);
        }
        parceiro.setTipoAssinatura(idAssinatura);

        var endereco = new Endereco(dadosEnderecoDTO);
        parceiro.setEndereco(endereco);
        endereco.setParceiro(parceiro);

        System.out.println(parceiro.getEndereco());
        parceiroRepository.save(parceiro);

        var uri = uriBuilder.path("/parceiro/{id}").buildAndExpand(parceiro.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoParceiroDAO(parceiro));
    }
}

