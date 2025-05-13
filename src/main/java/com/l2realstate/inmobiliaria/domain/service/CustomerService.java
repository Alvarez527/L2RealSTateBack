package com.l2realstate.inmobiliaria.domain.service;

import com.l2realstate.inmobiliaria.domain.Customer;
import com.l2realstate.inmobiliaria.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAll(){

        return customerRepository.getAll();
    }

    public Optional<Customer> getCustomerById(int customerId){

        return customerRepository.getCustomerById(customerId);
    }

    public Optional<Customer> getCustomerByName(String name){

        return customerRepository.getCustomerByName(name);
    }

    public Customer saveCustomer(Customer customer){

        return customerRepository.saveCustomer(customer);
    }

    public Boolean DeleteCustomer(int customerId){

        if (customerRepository.getCustomerById(customerId).isPresent()) {

            customerRepository.deleteCustomer(customerId);

            return true;
        }else {

            return false;
        }
    }

}

/*
*



    public void deleteCustomer(int customerId);
*
*
* */
