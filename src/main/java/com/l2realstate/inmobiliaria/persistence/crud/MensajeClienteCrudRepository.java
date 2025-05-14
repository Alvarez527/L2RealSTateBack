package com.l2realstate.inmobiliaria.persistence.crud;

import com.l2realstate.inmobiliaria.persistence.entity.MensajeCliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface MensajeClienteCrudRepository extends CrudRepository<MensajeCliente, Integer> {



    public Optional<List<MensajeCliente>> findByIdOperacionOrderByFechaMClienteAsc(Integer idOperacion);
}
