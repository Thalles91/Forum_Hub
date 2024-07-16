package com.alura.ForumHub.domain.reference;

import java.time.LocalDateTime;

public record ListingReferenceDTO(Long id, String titulo, String mensagem, LocalDateTime dataCriacao) {
    public ListingReferenceDTO(Reference reference){
        this(reference.getId(), reference.getTitulo(), reference.getMensagem(), reference.getDataCriacao());
    }
}
