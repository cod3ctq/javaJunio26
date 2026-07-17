package com.ddd_ms_prestamos.dto;

//Record : clase inmutable, a fin de ser utilizada como un dto
//Introducidos en java 14+
public record PrestamoRequest(int clienteId, int tipoPrestamoId, double monto) {

    // los record no necesitas que generes manualemente los constructores, getters/setters
    //debido a que son genetados  automaticamente en tiempo de ejecucion

    /*

     */
}
