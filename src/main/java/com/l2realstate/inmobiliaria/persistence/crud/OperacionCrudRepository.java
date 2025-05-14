package com.l2realstate.inmobiliaria.persistence.crud;

import com.l2realstate.inmobiliaria.persistence.entity.Operacion;
import org.springframework.data.repository.CrudRepository;

public interface OperacionCrudRepository extends CrudRepository<Operacion, Integer> {
}
