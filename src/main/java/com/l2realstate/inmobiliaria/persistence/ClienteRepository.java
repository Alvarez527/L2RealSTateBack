package com.l2realstate.inmobiliaria.persistence;

import com.l2realstate.inmobiliaria.domain.Customer;
import com.l2realstate.inmobiliaria.domain.repository.CustomerRepository;
import com.l2realstate.inmobiliaria.persistence.crud.ClienteCrudRepository;
import com.l2realstate.inmobiliaria.persistence.entity.Cliente;
import com.l2realstate.inmobiliaria.persistence.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository implements CustomerRepository {

    @Autowired
    ClienteCrudRepository clienteCrudRepository;

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public List<Customer> getAll() {

        List<Cliente> clientes = (List<Cliente>) clienteCrudRepository.findAll();

        return customerMapper.toCustomers(clientes);
    }

    @Override
    public Optional<Customer> getCustomerById(int customerId) {

        return clienteCrudRepository.findById(customerId).map( a -> customerMapper.toCustomer(a));
    }

    @Override
    public Optional<Customer> getCustomerByName(String name) {

        return clienteCrudRepository.findByNombreCliente(name).map(a -> customerMapper.toCustomer(a));
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        Cliente cliente = customerMapper.toCliente(customer);
        clienteCrudRepository.save(cliente);
        return customer;
    }

    public void deleteCustomer(int customerId) {

        clienteCrudRepository.deleteById(customerId);

    }
}
