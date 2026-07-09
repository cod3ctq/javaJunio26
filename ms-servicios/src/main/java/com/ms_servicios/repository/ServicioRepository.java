package com.ms_servicios.repository;


import com.ms_servicios.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository  extends JpaRepository<Servicio, Integer> {

}