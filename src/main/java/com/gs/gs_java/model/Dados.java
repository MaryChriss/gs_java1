package com.gs.gs_java.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TB_DADOS_CLIMATICOS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dados {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_dado")
    private Long idDados;

    @ManyToOne
    @JoinColumn(name = "id_dispositivo", nullable = false, foreignKey = @ForeignKey(name = "fk_dados_dispositivo"))
    private DispositivoIot dispositivo;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false, foreignKey = @ForeignKey(name = "fk_dados_usuario"))
    private User usuario;

    @Column(name = "data_coleta", nullable = false)
    private LocalDate dataColeta;

    @Column(name = "temperatura", precision = 5, scale = 2)
    private BigDecimal temperatura;

    @Column(name = "umidade", precision = 5, scale = 2)
    private BigDecimal umidade;

    @Column(name = "chuva_mm_1h", precision = 5, scale = 2)
    private BigDecimal chuva1h;

    @Column(name = "chuva_mm_3h", precision = 5, scale = 2)
    private BigDecimal chuva3h;

    @Column(name = "vento_vel_kmh", precision = 5, scale = 2)
    private BigDecimal ventoVelocidade;

    @Column(name = "descricao_clima", length = 100)
    private String descricaoClima;

    @Column(name = "cidade", length = 100)
    private String cidade;

    @Column(name = "lat_api", precision = 9, scale = 6)
    private BigDecimal latApi;

    @Column(name = "lon_api", precision = 9, scale = 6)
    private BigDecimal lonApi;
}
