package com.alura.ForumHub.controller;

import jakarta.validation.Valid;
import com.alura.ForumHub.domain.usuario.DadosAutenticacao;
import com.alura.ForumHub.domain.usuario.Usuario;
import com.alura.ForumHub.infra.security.DadosTokenJWT;
import com.alura.ForumHub.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
        var authenticationToken=new UsernamePasswordAuthenticationToken(dados.login(),dados.senha());
        var authentication=manager.authenticate(authenticationToken);
        var tokenJWT= tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
