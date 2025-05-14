package com.l2realstate.inmobiliaria.persistence.crud;

import com.l2realstate.inmobiliaria.persistence.entity.MensajeVendedor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MensajeVendedorCrudRepository extends CrudRepository<MensajeVendedor, Integer> {


    public Optional<List<MensajeVendedor>> findByIdOperacionOrderByFechaMVendedorAsc(Integer idOperacion);
}
