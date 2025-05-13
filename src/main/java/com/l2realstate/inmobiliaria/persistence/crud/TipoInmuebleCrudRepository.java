package com.l2realstate.inmobiliaria.persistence.crud;

import com.l2realstate.inmobiliaria.persistence.entity.InmueblesServicio;
import com.l2realstate.inmobiliaria.persistence.entity.TipoInmueble;
import org.springframework.data.repository.CrudRepository;

public interface TipoInmuebleCrudRepository extends CrudRepository<TipoInmueble, Integer> {

}
