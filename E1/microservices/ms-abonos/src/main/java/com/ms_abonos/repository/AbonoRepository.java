package com.ms_abonos.repository;

import com.ms_abonos.entity.Abono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonoRepository extends JpaRepository<Abono, Integer> {
}
