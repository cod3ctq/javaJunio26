package com.ms_servicios.repository;

import com.ms_servicios.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //DESIGNA EL ROL DAD A esta interface (aqui se habla con la base en idiopma objeto)
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
    //Si mas adelante necesito consultas mas elaboraas, se agg aqui
    //usando JPQL (SQL orientado a objetos)






}
