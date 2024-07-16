package com.alura.ForumHub.domain.reference.validations;

import com.alura.ForumHub.domain.ValidacaoException;
import com.alura.ForumHub.domain.reference.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DuplicateFreeValidator {
    private final ReferenceRepository referenceRepository;

    @Autowired
    public DuplicateFreeValidator(ReferenceRepository topicoRepository) {
        this.referenceRepository = topicoRepository;
    }

    public void validarDuplicidade(String titulo, String mensagem) {
        if (referenceRepository.existsByTituloAndMensagem(titulo, mensagem)) {
            throw new ValidacaoException("Já existe um tópico com o mesmo título e mensagem.");
        }
    }
}
