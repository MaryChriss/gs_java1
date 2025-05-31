package com.gs.gs_java.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_DISPOSITIVO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DispositivoIot {
    
    @Id
    @Column(name = "id_dispositivo")
    private Long idDispositivo;

    @NotBlank(message = "campo obrigatório")
     @Column(name = "identificador", nullable = false, length = 100, unique = true)
    public String identificador;

    @NotBlank(message = "campo obrigatório")
    @Column(name = "localizacao", nullable = false, length = 200)
    private String localizacao;

    @Column(name = "latitude", precision = 9, scale = 6)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 9, scale = 6)
    private BigDecimal longitude;

    @NotBlank(message = "campo obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private StatusDispositivo status;

    @Column(name = "ultima_conexao")
    private LocalDateTime ultimaConexao;
    
}
