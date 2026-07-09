package com.ms_prestamos.repository;

import com.ms_prestamos.entity.Prestamos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Designa el rol DAO a esta interface (Aquí se habla con la base en idioma objetos)
public interface PrestamoRepository extends JpaRepository<Prestamos,Integer> {
}
