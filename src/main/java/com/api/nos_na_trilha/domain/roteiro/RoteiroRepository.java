package com.api.nos_na_trilha.domain.roteiro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoteiroRepository extends JpaRepository<Roteiro, Long> {
    @Query("SELECT r FROM Roteiro r WHERE r.cidadeSaida = :cidade AND r.ufSaida = :uf")
    List<Roteiro> buscarPorCidadeEUf(String cidade, String uf);
}
