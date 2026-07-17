package com.ddd_ms_persistence.repository;


import com.ddd_ms_persistence.entity.TipoPrestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPrestamoRepository extends JpaRepository<TipoPrestamo, Integer> {
}
