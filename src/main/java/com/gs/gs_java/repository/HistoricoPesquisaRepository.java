package com.gs.gs_java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gs.gs_java.model.HistoricoPesquisa;
import com.gs.gs_java.model.User;

public interface HistoricoPesquisaRepository extends JpaRepository<HistoricoPesquisa, Long> {
    List<HistoricoPesquisa> findByUsuarioOrderByDataPesquisaDesc(User usuario);
    
    boolean existsByUsuarioAndCidadeIgnoreCase(User usuario, String cidade);
}
