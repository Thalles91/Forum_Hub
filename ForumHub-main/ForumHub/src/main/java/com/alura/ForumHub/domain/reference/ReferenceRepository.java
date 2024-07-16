package com.alura.ForumHub.domain.reference;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferenceRepository extends JpaRepository<Reference, Long> {
    boolean existsByTituloAndMensagem(String titulo, String mensagem);
}
