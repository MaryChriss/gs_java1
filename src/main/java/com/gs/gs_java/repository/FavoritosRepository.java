package com.gs.gs_java.repository;

import com.gs.gs_java.model.Favoritos;
import com.gs.gs_java.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritosRepository extends JpaRepository<Favoritos, Long> {
    
    List<Favoritos> findByUsuario(User usuario);

    boolean existsByUsuarioAndCidadeIgnoreCase(User usuario, String cidade);
}
