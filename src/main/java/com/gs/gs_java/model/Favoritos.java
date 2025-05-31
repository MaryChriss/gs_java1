package com.gs.gs_java.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TB_FAVORITOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Favoritos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "favorito_seq")
    @SequenceGenerator(name = "favorito_seq", sequenceName = "SEQ_FAVORITOS", allocationSize = 1)
    @Column(name = "id_favorito")
    private Long idFavorito;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false, foreignKey = @ForeignKey(name = "fk_favorito_usuario"))
    private User usuario;

    @Column(name = "cidade", nullable = false, length = 100)
    private String cidade;

    @Column(name = "lat_api", nullable = false, precision = 9, scale = 6)
    private BigDecimal latApi;

    @Column(name = "lon_api", nullable = false, precision = 9, scale = 6)
    private BigDecimal lonApi;

    @Column(name = "data_favorito")
    private LocalDate dataFavorito = LocalDate.now();
}
