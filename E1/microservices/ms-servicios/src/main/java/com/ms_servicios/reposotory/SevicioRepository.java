package com.ms_servicios.reposotory;

import com.ms_servicios.entity.Servicio;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Desinga el roll dao a esta interface(aqui se habla von la base en el idioma objeto)
public interface SevicioRepository extends JpaRepository<Servicio, Integer>
{
    //si mas adelante necesitas mas elaboradas, se agragan aqui
    //usando JPQL(SQL orientado a objetos)

}
