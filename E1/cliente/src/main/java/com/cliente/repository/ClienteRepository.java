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

    //consulta JPQL : ORIENTADA A OBJETO
    //@Query SIRVE PARA DESARROLLAR A EXACTUTUD LA CONSULTA DECEADA A TRAVESS DE JPQL
    //SELECT*FROM CLIENTES WHERE TELEFONO = '232467890'
    @Query("SELECT c FROM Cliente c WHERE c.telefono=:tel") //Consulta orientada a objetos
    Optional<Cliente> findByTelefono(@Param("tel") String tel);

    @Query("SELECT c FROM Cliente c WHERE c.correo=:email") //Consulta orientada a objetos
    Optional<Cliente> findByCorreo(@Param("email") String email);

    @Query("SELECT c FROM Cliente c WHERE c.ine=:ine") //Consulta orientada a objetos
    Optional<Cliente> findByIne(@Param("ine") String ine);

    @Query("SELECT c FROM Cliente c WHERE c.rfc=:rfc") //Consulta orientada a objetos
    Optional<Cliente> findByRfc(@Param("rfc") String rfc);




}
