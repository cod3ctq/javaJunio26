package com.ms_servicios.repository;


import com.ms_servicios.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Designa el rol DAO a esta interface (aqui se habla con la base en idioma objetos)
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
    //Si mas adelante necesito consultas mas elaboradas, se agregan aqui
    //usando JPQL (SQL orientado a objetos)
}
