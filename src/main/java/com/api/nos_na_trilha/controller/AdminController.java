package com.api.nos_na_trilha.controller;

import com.api.nos_na_trilha.domain.admin.Admin;
import com.api.nos_na_trilha.domain.admin.AdminRepository;
import com.api.nos_na_trilha.domain.admin.DadosCadastroAdmin;
import com.api.nos_na_trilha.domain.admin.DadosDetalhamentoAdmin;
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
    private AdminRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAdmin dados, UriComponentsBuilder uriBuilder) {
        var admin = new Admin(dados);

        repository.save(admin);

        var uri = uriBuilder.path("/admin/{id}").buildAndExpand(admin.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoAdmin(admin));
    }


}
