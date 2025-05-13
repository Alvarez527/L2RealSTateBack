package com.l2realstate.inmobiliaria.persistence.mapper;

import com.l2realstate.inmobiliaria.domain.Customer;
import com.l2realstate.inmobiliaria.persistence.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mappings({

            @Mapping(source = "idCliente", target="customerId"),
            @Mapping(source = "nombreCliente", target="customerName"),
            @Mapping(source = "telefonoCliente", target="mobileNumber"),
            @Mapping(source = "emailCliente", target="customerEmail")
    })

    Customer toCustomer(Cliente cliente);
    List<Customer> toCustomers(List<Cliente> clientes);

    @InheritInverseConfiguration
    public Cliente toCliente(Customer customer);
    public List<Cliente> toCliente(List<Customer> customers);
}




