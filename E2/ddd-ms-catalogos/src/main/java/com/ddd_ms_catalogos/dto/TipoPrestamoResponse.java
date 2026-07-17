package com.ddd_ms_catalogos.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public record TipoPrestamoResponse(int tipoPrestamoId, String descripcion,
                                   int interes,int plazo) {
}
