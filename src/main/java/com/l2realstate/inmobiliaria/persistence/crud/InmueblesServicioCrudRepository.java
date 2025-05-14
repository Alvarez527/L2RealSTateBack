package com.l2realstate.inmobiliaria.persistence.crud;


import com.l2realstate.inmobiliaria.persistence.entity.InmueblesServicio;
import com.l2realstate.inmobiliaria.persistence.entity.InmueblesServicioPK;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface InmueblesServicioCrudRepository extends CrudRepository<InmueblesServicio, InmueblesServicioPK> {

    Optional<List<InmueblesServicio>> findByInmueble_idInmueble(Integer idInmueble);

}
