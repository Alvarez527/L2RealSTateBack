package com.l2realstate.inmobiliaria.persistence.crud;

import com.l2realstate.inmobiliaria.persistence.entity.Colonia;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ColoniaCrudRepository extends CrudRepository<Colonia, Integer> {

    Optional<Colonia> findByColonia(String colonia);

}
