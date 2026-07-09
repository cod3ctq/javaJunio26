

//Reposotory
// Es la capa que se encarga de comunicarse con la base de datos
//Su funcion es realizar las operaciones CRUD crear, leer actualizar y eliminar
//sin que tengas que escribir consultas SQL para las operaciones mas comunes


package com.ms_tipo_tarjeta.repository;

import com.ms_tipo_tarjeta.entity.TipoTarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Importa la interfaz que contiene metodos ya hechos para trabajar con la base de datos

@Repository
public interface TipoTarjetaRepository extends JpaRepository<TipoTarjeta, Integer> {
//interface es un contrato que Spring implementa automaticamente
    //extends significa que hereda los metodos de JpaRepository.
    //findAll() obtiene todos los registros
    //save()guarda un registro
    //findById() Busca por ID
    //deleteById () elimina por Id
}
