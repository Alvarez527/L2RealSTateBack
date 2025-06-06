package com.l2realstate.inmobiliaria.persistence.crud;

import com.l2realstate.inmobiliaria.domain.State;
import com.l2realstate.inmobiliaria.persistence.entity.Estado;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EstadoCrudRepository extends CrudRepository<Estado, Integer> {

    Optional<Estado> findByEstado(String estado);

}


