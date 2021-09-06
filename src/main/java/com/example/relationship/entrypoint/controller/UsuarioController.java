package com.example.relationship.entrypoint.controller;

import java.util.List;

import com.example.relationship.dataprovider.entity.Situacao;
import com.example.relationship.dataprovider.entity.Tipo;
import com.example.relationship.dataprovider.entity.Usuario;
import com.example.relationship.dataprovider.entity.UsuarioRepository;
import com.example.relationship.dataprovider.repository.SituacaoRepository;
import com.example.relationship.dataprovider.repository.TipoRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;
    private TipoRepository tipoRepository;
    private SituacaoRepository situacaoRepository;
    

    @GetMapping
    public List<Usuario> getUsuarios() {

        Tipo tipo1 = tipoRepository.save(Tipo.builder().name("admin").description("acesso a todas as roles").build());
        Tipo tipo2 = tipoRepository.save(Tipo.builder().name("rh").description("acesso a roles de rh").build());
        Situacao situacao1 = situacaoRepository.save(Situacao.builder().name("ativo").description("em uso").build());
        Situacao situacao2 = situacaoRepository.save(Situacao.builder().name("inativo").description("não esta em uso").build());

        //Tipo tipo1 = Tipo.builder().name("admin").description("acesso a todas as roles").build();
        //Tipo tipo2 = Tipo.builder().name("rh").description("acesso a roles de rh").build();

        //Situacao situacao1 = Situacao.builder().name("ativo").description("em uso").build();
        //Situacao situacao2 = Situacao.builder().name("inativo").description("não esta em uso").build();

        usuarioRepository.saveAll(List.of(
            Usuario.builder().name("Vinicius") 
                .tipo(tipo1) 
                .situacao(situacao1).build(),
            Usuario.builder().name("Adrieli") 
                .tipo(tipo2) 
                .situacao(situacao2).build()
        ));
        
        return usuarioRepository.findAll();
        
    }

    @DeleteMapping
    public void deleteTipo() {
        Tipo tipo1 = tipoRepository.findById("admin").get();
        tipoRepository.delete(tipo1);
    }


}
