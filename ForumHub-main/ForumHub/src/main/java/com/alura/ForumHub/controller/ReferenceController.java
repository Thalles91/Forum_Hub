package com.alura.ForumHub.controller;

import com.alura.ForumHub.domain.reference.*;
import com.alura.ForumHub.domain.reference.validations.ValidatorId;
import com.alura.ForumHub.domain.reference.validations.DuplicateFreeValidator;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("details")
public class ReferenceController {

    @Autowired
    private ReferenceRepository repository;

    @Autowired
    private DuplicateFreeValidator duplicateFreeValidator;

    @Autowired
    private ValidatorId validatorId;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid RegisterReferenceDTO dados, UriComponentsBuilder uriBuilder, Authentication autenticado){
            duplicateFreeValidator.validarDuplicidade(dados.titulo(), dados.mensagem());
            var topico=new Reference(dados, autenticado.getName());
            repository.save(topico);
            var uri=uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
            return ResponseEntity.created(uri).body(new DetailingReferenceDTO(topico));
    }

    @GetMapping
    public ResponseEntity<Page<ListingReferenceDTO>> listar(@PageableDefault(size = 10, sort = {"titulo"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(ListingReferenceDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        validatorId.validar(id);
        var topico=repository.getReferenceById(id);
        return ResponseEntity.ok(new DetailingReferenceDTO(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid AtuthenticReferenceDTO dados){
        validatorId.validar(id);
        var reference =repository.getReferenceById(id);
        reference.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DetailingReferenceDTO(reference));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        validatorId.validar(id);
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
