package com.api.nos_na_trilha.controller;


import com.api.nos_na_trilha.domain.parceiro.*;
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
@RequestMapping("/parceiro")
public class ParceiroController {

    @Autowired
    private AuthService authService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid ParceiroAssociations dadosComEndereco,
                                    UriComponentsBuilder uri) {
        return authService.cadastrarEmpresa(dadosComEndereco.getParceiroDados(), dadosComEndereco.getDadosEndereco(), uri);
    }
}
