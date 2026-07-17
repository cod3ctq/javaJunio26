package com.ms_prestamos.repository;

import com.cliente.entity.Cliente;
import com.ms_prestamos.entity.Prestamos;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // Designa el rol DAO a esta interface (Aquí se habla con la base en idioma objetos)
public interface PrestamoRepository extends JpaRepository<Prestamos,Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Prestamos p SET p.status='0' WHERE p.prestamoId=:id")
    void desactivarPrestamo(@Param("id") int id);

    @Query("SELECT p FROM Prestamos p WHERE p.status = '1'")
    Optional<List<Prestamos>> findAllActive();

}
