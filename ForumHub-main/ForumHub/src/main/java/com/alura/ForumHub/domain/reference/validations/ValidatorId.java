package com.alura.ForumHub.domain.reference.validations;

import com.alura.ForumHub.domain.ValidacaoException;
import com.alura.ForumHub.domain.reference.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatorId {

    @Autowired
    ReferenceRepository repository;
    public void validar(Long id) {
        if (id == null || id <= 0) {
            throw new ValidacaoException("ID do tópico inválido. Forneça um ID válido.");
        }
        var reference=repository.findById(id).orElseThrow(() -> new ValidacaoException("Tópico não encontrado com o ID: " + id));
    }
}
