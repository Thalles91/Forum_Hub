package com.alura.ForumHub.domain.reference;

import jakarta.validation.constraints.NotNull;

public record AtuthenticReferenceDTO(@NotNull String titulo, @NotNull
                                     String mensagem) {
}
