package com.api.nos_na_trilha.domain.parceiro;

import org.springframework.data.jpa.repository.JpaRepository;
public interface ParceiroRepository extends JpaRepository<Parceiro, Long> {
    boolean existsByEmail(String email);
    Parceiro findByEmail(String email);
}
