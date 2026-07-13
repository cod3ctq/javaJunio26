package com.ms_prestamos.repository;

import com.ms_prestamos.entity.Prestamos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository // Designa el rol DAO a esta interface (Aquí se habla con la base en idioma objetos)
public interface PrestamoRepository extends JpaRepository<Prestamos,Integer> {

    @Transactional//Asegura la consistencia de la operacion, si falla, revierte automaticamente los ca,bios
    @Modifying
    @Query("UPDATE prestamos p SET p.status='0' WHERE p.prestamosId=id")
    void desactivarPrestamos(@Param("id")int id);
}
