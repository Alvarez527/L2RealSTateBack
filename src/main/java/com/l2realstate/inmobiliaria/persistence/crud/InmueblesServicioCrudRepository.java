package com.l2realstate.inmobiliaria.persistence.crud;

import com.l2realstate.inmobiliaria.domain.PropertiesService;
import com.l2realstate.inmobiliaria.domain.Service;
import com.l2realstate.inmobiliaria.persistence.entity.InmueblesServicio;
import com.l2realstate.inmobiliaria.persistence.entity.InmueblesServicioPK;
import com.l2realstate.inmobiliaria.persistence.entity.Servicio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface InmueblesServicioCrudRepository extends CrudRepository<InmueblesServicio, InmueblesServicioPK> {

    Optional<InmueblesServicio> findByDescripcionServicio(String descripcionServicio);


    Optional<List<InmueblesServicio>> findByInmueble_idInmueble(int idInmueble);


}

