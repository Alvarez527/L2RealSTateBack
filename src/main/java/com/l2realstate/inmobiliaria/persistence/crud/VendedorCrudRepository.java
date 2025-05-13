package com.l2realstate.inmobiliaria.persistence.crud;

import com.l2realstate.inmobiliaria.persistence.entity.Cliente;
import com.l2realstate.inmobiliaria.persistence.entity.Vendedor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VendedorCrudRepository extends CrudRepository<Vendedor, Integer> {

    public Optional<Vendedor> findByNombreVendedor(String nombreVendedor);
}
