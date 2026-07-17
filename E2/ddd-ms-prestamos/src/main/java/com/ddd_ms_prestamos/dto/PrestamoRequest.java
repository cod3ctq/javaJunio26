package com.ddd_ms_prestamos.dto;

//Record: clase inmutable, a fin de ser utilizada como un dto
//Introducido en java 14+
public record PrestamoRequest(int clienteId, int tipoPrestamoId, double monto) {
    //Los records no necesitan que manuamente generes los constractores getters y setters debido a que son generados automaticamente en tiempos de ejecucion
}
