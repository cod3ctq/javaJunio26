package com.ms_servicios.repository;


import com.ms_servicios.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //designa el roll dao a esta inteface (qui se habla con la base en idioma objetos)
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
    //si mas adelante necesito consultas nas elaboradas se agregan aqui
    //usando JPQL (sql orientado a objetos)

}
