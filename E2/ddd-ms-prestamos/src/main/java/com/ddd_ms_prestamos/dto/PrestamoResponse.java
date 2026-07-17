package com.ddd_ms_prestamos.dto;

import java.time.LocalDate;

//status: DISPONIBLE, DENEGADO, REGISTRADO
public record PrestamoResponse(int interes, double solicitado, double totalPorPagar,
                               double pagoMensualEstimado, int mesualidades,
                               LocalDate fechaCalculo, String status){
}
