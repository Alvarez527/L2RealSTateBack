package com.l2realstate.inmobiliaria.persistence.crud;


import com.l2realstate.inmobiliaria.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface ClienteCrudRepository extends CrudRepository<Cliente, Integer>{


    public Optional<Cliente> findByNombreCliente(String nombreCliente);
}

