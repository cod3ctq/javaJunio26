package com.ddd_ms_prestamos.dto;

//Record : clase inmutable, a fin de ser utilizada como un dto
public record PrestamoRequest(int clienteId, int tipoPrestamoId, double monto) {
}
//Los records no necesitan que manualmente generes los constructores , getters/setters debiado a que son generados
//automaticamente en tiempo de ejecciion