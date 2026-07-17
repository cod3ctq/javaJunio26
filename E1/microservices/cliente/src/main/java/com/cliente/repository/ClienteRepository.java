package com.cliente.repository;

import com.cliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// DAO
@Repository // Establece la responsabilidad de las operaciones de acceso a datos (DAO)
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    //Consulta JPQL: orientada a objetos
    //@Query: Sirve para desarrollar a exactitud la consulta deseada a traves de JPQL
    //SELECT * FRPM CLIENTES WHERE TELEFONO = '54354513'
    @Query("SELECT c FROM Cliente c WHERE c.telefono=:tel")
    Optional<Cliente> findByTelefono (@Param("tel") String tel);

    @Query("SELECT c FROM Cliente c WHERE c.correo=:email")
    Optional<Cliente> findByCorreo (@Param("email") String email);

    @Query("SELECT c FROM Cliente c WHERE c.ine=:ine")
    Optional<Cliente> findByIne (@Param("ine") String ine);

    @Query("SELECT c FROM Cliente c WHERE c.rfc=:rfc")
    Optional<Cliente> findByRfc (@Param("rfc") String rfc);


}
