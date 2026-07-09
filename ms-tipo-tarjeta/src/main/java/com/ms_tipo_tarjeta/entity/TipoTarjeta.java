package com.ms_tipo_tarjeta.entity;



//Entidad
//Mapeo replicar de manera exacta la estructura de una tabla de base de datod


import jakarta.persistence.*;

import java.io.Serializable;
// Importa todas las anotaciones de jpa (Java percistence  API)
// Sirve para decilrle a spring como relacionar
// una clase con una tabla de la base de datos


@Entity//Le indica a Spring que esta clase representa una tabla de la base de datos
@Table(name= "TIPO_TARJETA")// Indica el nombre de la tabla en oracle
public class TipoTarjeta implements Serializable {
// Se crea una clase llamada tipoTarjeta
// Eta clase representa un registor de la tabla

    @Id  //Marca cual es la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Le dice a Spring que el id sera generado automaticamente por la db
    //Cuando haces un incert no necesitas escribir el id
    @Column(name="TIPO_T_ID", columnDefinition = "NUMBER")
    //Relaciona el atributo de Java con con la columna de oracle
    private int tipoTId;//Decalra una variable donde se almacena el ID

    @Column(name="DESCRIPCION",columnDefinition = "VARCHAR2(10)")
    private String descripcion;

    //Guarda la descripcion del tipo de tarjeta

   //   Getter


    public int getTipoTId() {
        return tipoTId;
    }

    public void setTipoTId(int tipoTId) {
        this.tipoTId = tipoTId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
