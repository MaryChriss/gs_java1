package com.gs.gs_java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs.gs_java.dto.FavoritosDTO;
import com.gs.gs_java.model.Favoritos;
import com.gs.gs_java.model.User;
import com.gs.gs_java.repository.FavoritosRepository;
import com.gs.gs_java.repository.UserRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/favoritos")
public class FavoritosController {
    
    @Autowired
    private FavoritosRepository favoritoRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> adicionarFavorito(@RequestBody @Valid FavoritosDTO dto) {
        User usuario = userRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        boolean jaExiste = favoritoRepository.existsByUsuarioAndCidadeIgnoreCase(usuario, dto.getCidade());

        if (jaExiste) {
            return ResponseEntity.status(409).body("Cidade já está favoritada por esse usuário.");
        }

        Favoritos favorito = Favoritos.builder()
                .usuario(usuario)
                .cidade(dto.getCidade())
                .latApi(dto.getLatApi())
                .lonApi(dto.getLonApi())
                .build();

        return ResponseEntity.ok(favoritoRepository.save(favorito));
    }

    @GetMapping("/{idUsuario}")
    public List<Favoritos> listarFavoritos(@PathVariable Long idUsuario) {
        User usuario = userRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return favoritoRepository.findByUsuario(usuario);
    }
    
    @DeleteMapping("/{idFavorito}")
    public void removerFavorito(@PathVariable Long idFavorito) {
    favoritoRepository.deleteById(idFavorito);
}


}
