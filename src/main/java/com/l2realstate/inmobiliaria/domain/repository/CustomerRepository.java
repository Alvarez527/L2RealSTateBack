package com.l2realstate.inmobiliaria.domain.repository;

import com.l2realstate.inmobiliaria.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    public List<Customer> getAll();

    public Optional<Customer> getCustomerById(int customerId);

    public Optional<Customer> getCustomerByName(String name);

    public Customer saveCustomer(Customer customer);

    public void deleteCustomer(int customerId);

}


