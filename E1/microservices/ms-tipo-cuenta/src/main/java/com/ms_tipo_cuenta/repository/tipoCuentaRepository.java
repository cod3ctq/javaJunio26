package com.ms_tipo_cuenta.repository;

import com.ms_tipo_cuenta.entity.tipoCuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface tipoCuentaRepository extends JpaRepository<tipoCuenta, Integer> {}

