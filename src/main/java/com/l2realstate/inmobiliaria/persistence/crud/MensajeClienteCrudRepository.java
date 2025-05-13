package com.l2realstate.inmobiliaria.persistence.crud;

import com.l2realstate.inmobiliaria.persistence.entity.MensajeCliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


//Esta interfaz recibe el nombre de la table y el tipo de dato de la clave primaria
public interface MensajeClienteCrudRepository extends CrudRepository<MensajeCliente, Integer> {

    Optional<List<MensajeCliente>> findByIdOperacionOrderByFechaMClienteAsc(int idOperacion);
}
