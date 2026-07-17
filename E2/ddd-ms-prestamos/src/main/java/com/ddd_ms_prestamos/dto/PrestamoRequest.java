package com.ddd_ms_prestamos.dto;

//Record : clase inmutable, a fin de ser utilizada como un dto
// Introducidos en Java 14+
public record PrestamoRequest(int clienteId, int tipoPrestamoId, double monto) {

    // Los records no necesitan que manualmente generes los contructores, getters/setters
    // debido a que son generados automaticamente en tiempo de ejecución
}
