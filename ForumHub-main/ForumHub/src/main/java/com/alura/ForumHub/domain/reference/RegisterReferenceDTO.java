package com.alura.ForumHub.domain.reference;

import jakarta.validation.constraints.NotBlank;

public record RegisterReferenceDTO(
        @NotBlank
        String titulo,
        @NotBlank
        String curso,
        @NotBlank
        String mensagem

) {
}
