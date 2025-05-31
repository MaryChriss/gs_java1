package com.gs.gs_java.controller;

import com.gs.gs_java.model.HistoricoPesquisa;
import com.gs.gs_java.model.User;
import com.gs.gs_java.repository.HistoricoPesquisaRepository;
import com.gs.gs_java.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historico")
public class HistoricoPesquisaController {

    @Autowired
    private HistoricoPesquisaRepository historicoRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{idUsuario}")
    public List<HistoricoPesquisa> listarHistorico(@PathVariable Long idUsuario) {
        User usuario = userRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return historicoRepository.findByUsuarioOrderByDataPesquisaDesc(usuario);
    }
}
