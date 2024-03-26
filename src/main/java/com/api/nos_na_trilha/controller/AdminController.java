package com.api.nos_na_trilha.controller;

import com.api.nos_na_trilha.domain.admin.*;
import com.api.nos_na_trilha.service.AuthService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AuthService authService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAdmin dados, UriComponentsBuilder uriBuilder) {
       return authService.cadastrar(dados, uriBuilder);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid DadosLoginAdmin dados) {
        return authService.login(dados);
    }

}
