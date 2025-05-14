package com.l2realstate.inmobiliaria.persistence.crud;

import com.l2realstate.inmobiliaria.persistence.entity.Vendedor;
import org.springframework.data.repository.CrudRepository;

import java.nio.channels.FileChannel;
import java.util.Optional;

public interface VendedorCrudRepository extends CrudRepository<Vendedor, Integer> {

    Optional<Vendedor> findByNombreVendedor(String name);
}
