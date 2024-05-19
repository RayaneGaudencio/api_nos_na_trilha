package com.api.nos_na_trilha.controller;


import com.api.nos_na_trilha.domain.roteiro.DadosCadastroRoteiro;
import com.api.nos_na_trilha.domain.roteiro.Roteiro;
import com.api.nos_na_trilha.service.RoteiroService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

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

    @GetMapping("/busca")
    public ResponseEntity<List<Roteiro>> buscarPorCidadeEstado(@RequestParam String cidade, @RequestParam String estado) {
        return roteiroService.buscarPorCidadeEstado(cidade, estado);
    }

    @GetMapping("/busca_por_categoria")
    public ResponseEntity<List<Roteiro>> buscarPorCategoria(@RequestParam String categoria) {
        return roteiroService.buscarPorCategoria(categoria);
    }

    @GetMapping("/todos_roteiros")
    public ResponseEntity<List<Roteiro>> todosRoteiros() {
        return ResponseEntity.ok(roteiroService.listarTodosRoteiros());
    }
}
