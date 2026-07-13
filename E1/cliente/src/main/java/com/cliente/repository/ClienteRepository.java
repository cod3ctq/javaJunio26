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
    //consulta JPQL: orientada a objetos
    //@Query sirve para desarrollar a exactitud la consulta deseada a traves de JPQL
    //EN JDBC EL / TE DA LA POSICION
    //@Query("SELECT * FROM CLIENTES WHERE TELEFONO =")
    //consulta orientada a objetos, la c es objeto de la entidad que apunta a la clase
    // los : es para concatenar los valores que van a pasar
    //debe coincidir en los 3 lugares de tel
    // Consultas JPA
    //                                     telefono tiene que esta declarado como esta en Cliente
    @Query("SELECT c FROM Cliente c WHERE c.telefono=:tel")
    Optional<Cliente> findByTelefono(@Param("tel") String tel);

    @Query("SELECT c FROM Cliente c WHERE c.correo=:email")
    Optional<Cliente> findByCorreo(@Param("email") String email);

    @Query("SELECT c FROM Cliente c WHERE c.ine=:ine")
    Optional<Cliente> findByIne(@Param("ine") String ine);

    @Query("SELECT c FROM Cliente c WHERE c.rfc=:rfc")
    Optional<Cliente> findByRfc(@Param("rfc") String rfc);
}
