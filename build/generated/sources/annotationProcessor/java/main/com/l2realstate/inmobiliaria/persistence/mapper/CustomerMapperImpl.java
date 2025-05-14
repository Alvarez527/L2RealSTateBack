package com.l2realstate.inmobiliaria.persistence.mapper;

import com.l2realstate.inmobiliaria.domain.Customer;
import com.l2realstate.inmobiliaria.persistence.entity.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-14T12:05:40-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toCustomer(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        Customer customer = new Customer();

        if ( cliente.getIdCliente() != null ) {
            customer.setCustomerId( cliente.getIdCliente() );
        }
        customer.setCustomerName( cliente.getNombreCliente() );
        customer.setMobileNumber( cliente.getTelefonoCliente() );
        customer.setCustomerEmail( cliente.getEmailCliente() );

        return customer;
    }

    @Override
    public List<Customer> toCustomers(List<Cliente> clientes) {
        if ( clientes == null ) {
            return null;
        }

        List<Customer> list = new ArrayList<Customer>( clientes.size() );
        for ( Cliente cliente : clientes ) {
            list.add( toCustomer( cliente ) );
        }

        return list;
    }

    @Override
    public Cliente toCliente(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setIdCliente( customer.getCustomerId() );
        cliente.setNombreCliente( customer.getCustomerName() );
        cliente.setTelefonoCliente( customer.getMobileNumber() );
        cliente.setEmailCliente( customer.getCustomerEmail() );

        return cliente;
    }

    @Override
    public List<Cliente> toCliente(List<Customer> customers) {
        if ( customers == null ) {
            return null;
        }

        List<Cliente> list = new ArrayList<Cliente>( customers.size() );
        for ( Customer customer : customers ) {
            list.add( toCliente( customer ) );
        }

        return list;
    }
}
