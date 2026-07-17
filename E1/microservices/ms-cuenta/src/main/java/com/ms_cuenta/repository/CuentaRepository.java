package com.ms_cuenta.repository;

import com.ms_cuenta.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
    //si mas adelante necesito consultas nas elaboradas se agregan aqui
    //usando JPQL (sql orientado a objetos)
}
