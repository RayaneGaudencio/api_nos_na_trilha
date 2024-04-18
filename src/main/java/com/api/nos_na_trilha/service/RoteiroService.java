package com.api.nos_na_trilha.service;


import com.api.nos_na_trilha.domain.parceiro.ParceiroRepository;
import com.api.nos_na_trilha.domain.roteiro.DadosCadastroRoteiro;
import com.api.nos_na_trilha.domain.roteiro.Roteiro;
import com.api.nos_na_trilha.domain.roteiro.RoteiroRepository;
import jakarta.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class RoteiroService {

    @Autowired
    private RoteiroRepository roteiroRepository;

    @Autowired
    private ParceiroRepository parceiroRepository;
    public ResponseEntity cadastrar(DadosCadastroRoteiro dados, UriComponentsBuilder uri) {

        if (!parceiroRepository.existsById(dados.idParceiro())) {
            return ResponseEntity.notFound().build();
        }

        try {
            var roteiro = new Roteiro(dados);
            roteiro.setIdParceiro(dados.idParceiro());
            roteiroRepository.save(roteiro);


            var uriBuilder = uri.path("/roteiro/{id}").buildAndExpand(roteiro.getId()).toUri();
            return ResponseEntity.created(uriBuilder).body(roteiro);
        } catch (PersistenceException e) {
            return ResponseEntity.badRequest().body("Erro ao salvar roteiro: " + e.getMessage());
        }

    }

    public ResponseEntity<List<Roteiro>> buscarPorCidadeEstado(String cidade, String estado) {
        List<Roteiro> roteiros = roteiroRepository.buscarPorCidadeEUf(cidade, estado);

        if (roteiros.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(roteiros);
        }
    }

    public ResponseEntity<List<Roteiro>> buscarPorCategoria(String categoria) {
        List<Roteiro> roteiros = roteiroRepository.findByCategoria(categoria);

        if (roteiros.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(roteiros);
        }
    }
}
