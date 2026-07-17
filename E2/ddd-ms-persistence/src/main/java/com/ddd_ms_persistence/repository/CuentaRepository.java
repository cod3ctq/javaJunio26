package com.ddd_ms_persistence.repository;


import com.ddd_ms_persistence.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

    @Query("SELECT c FROM Cuenta c WHERE c.clienteId=:id")
    Optional<Cuenta> findByClienteId(@Param("id") int id);
}

