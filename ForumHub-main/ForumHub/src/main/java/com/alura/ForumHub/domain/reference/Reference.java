package com.alura.ForumHub.domain.reference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Table(name="details")
@Entity(name = "Reference")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Reference {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String status;
    private String autor;
    private String curso;
    @ElementCollection
    private List<String> respostas;


    public Reference(RegisterReferenceDTO dados, String usuarioLogado) {
        this.titulo= dados.titulo();
        this.mensagem= dados.mensagem();
        this.dataCriacao=LocalDateTime.now();
        this.status="NAO_RESPONDIDO";
        this.autor=usuarioLogado;
        this.curso= dados.curso();
    }

    public void atualizarInformacoes(AtuthenticReferenceDTO dados) {
        if(dados.titulo()!=null){
            this.titulo=dados.titulo();
        }
        if (dados.mensagem()!=null){
            this.mensagem=dados.mensagem();
        }
    }
}
