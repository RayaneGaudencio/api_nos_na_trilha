package com.api.nos_na_trilha.service;

import com.api.nos_na_trilha.domain.admin.*;
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
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } else {
            ErrorResponse errorResponse = new ErrorResponse("Não foi possível encontrar o usuário.", HttpStatus.NOT_FOUND.value());
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorResponse);
        }
    }
}

