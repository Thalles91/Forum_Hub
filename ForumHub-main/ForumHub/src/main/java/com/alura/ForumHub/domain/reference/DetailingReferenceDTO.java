package com.alura.ForumHub.domain.reference;

import java.time.LocalDateTime;
import java.util.List;

public record DetailingReferenceDTO(Long id, String titulo, String mensagem, LocalDateTime dataCriacao, String nomeAutor, String status, List<String> respostas) {
    public DetailingReferenceDTO(Reference reference){
        this(reference.getId(), reference.getTitulo(), reference.getMensagem(), reference.getDataCriacao(), reference.getAutor(), reference.getStatus(), reference.getRespostas());
    }
}
