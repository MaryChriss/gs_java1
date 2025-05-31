package com.gs.gs_java.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class FavoritosDTO {
    @NotNull
    private Long idUsuario;

    @NotNull
    private String cidade;

    @NotNull
    private BigDecimal latApi;

    @NotNull
    private BigDecimal lonApi;
}
