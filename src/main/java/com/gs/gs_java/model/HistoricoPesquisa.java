package com.gs.gs_java.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.ForeignKey;

@Entity
@Table(name = "TB_HISTORICO_PESQUISA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoricoPesquisa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "historico_seq")
    @SequenceGenerator(name = "historico_seq", sequenceName = "SEQ_HISTORICO_PESQUISA", allocationSize = 1)
    @Column(name = "id_historico")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false, foreignKey = @ForeignKey(name = "fk_historico_usuario"))
    private User usuario;

    @Column(name = "cidade", nullable = false, length = 100)
    private String cidade;

    @Column(name = "data_pesquisa")
    private LocalDateTime dataPesquisa;
}

