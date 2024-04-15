package com.api.nos_na_trilha.controller;


import com.api.nos_na_trilha.domain.roteiro.DadosCadastroRoteiro;
import com.api.nos_na_trilha.service.RoteiroService;
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
@RequestMapping("/roteiro")
public class RoteiroController {


    @Autowired
    private RoteiroService roteiroService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroRoteiro dados, UriComponentsBuilder uri) {
        return roteiroService.cadastrar(dados, uri);
    }
}
