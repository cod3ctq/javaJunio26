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

    //consulta jpql
    //@Query sirve para desarollar aexactitud la consulta deseada a teves de jpql
    //select *  from clientes where  Telefono= "valorNumeroTelefono"
    //una consulta orienta a cliente
    @Query("SELECT C FROM Cliente C WHERE C.telefono =:tel")
    Optional<Cliente> findByTelefono(@Param("tel") String tel);

    @Query("SELECT C FROM Cliente C WHERE C.correo =:email")
    Optional<Cliente> findByCorreo(@Param("email") String email);

    @Query("SELECT C FROM Cliente C WHERE C.ine =:ine")
    Optional<Cliente> findByIne(@Param("ine") String ine);

    @Query("SELECT C FROM Cliente C WHERE C.rfc =:rfc")
    Optional<Cliente> findByRfc(@Param("rfc") String rfc);




}
