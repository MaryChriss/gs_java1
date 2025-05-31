package com.gs.gs_java.controller;

import com.gs.gs_java.model.Dados;
import com.gs.gs_java.model.HistoricoPesquisa;
import com.gs.gs_java.model.User;
import com.gs.gs_java.repository.DadosRepository;
import com.gs.gs_java.repository.HistoricoPesquisaRepository;
import com.gs.gs_java.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dados")
public class DadosController {

    @Autowired
    private DadosRepository DadosRepository;

    @Autowired
    private UserRepository UserRepository;

     @Autowired
    private HistoricoPesquisaRepository historicoRepository;

 @GetMapping
    public Page<Dados> listarComFiltroCidade(
        @RequestParam(required = false) String cidade,
        @RequestParam(required = false) Long idUsuario,
        Pageable pageable) {

        if (cidade != null && !cidade.isBlank()) {
            if (idUsuario != null) {
                User usuario = UserRepository.findById(idUsuario)
                        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

                boolean jaPesquisada = historicoRepository.existsByUsuarioAndCidadeIgnoreCase(usuario, cidade);

                if (!jaPesquisada && cidade.matches("^[A-Za-zÀ-ÿ\\s]+$")) {
                    HistoricoPesquisa historico = HistoricoPesquisa.builder()
                            .usuario(usuario)
                            .cidade(cidade.trim())
                            .dataPesquisa(LocalDateTime.now())
                            .build();
                    historicoRepository.save(historico);
                }
            }

            return DadosRepository.findByCidadeContainingIgnoreCase(cidade, pageable);
        }

        return DadosRepository.findAll(pageable);
    }

}
