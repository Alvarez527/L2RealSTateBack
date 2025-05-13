package com.l2realstate.inmobiliaria.domain.service;

import com.l2realstate.inmobiliaria.domain.SalesPerson;
import com.l2realstate.inmobiliaria.domain.repository.SalesPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesPersonService {

    @Autowired
    SalesPersonRepository salesPersonRepository;

    public List<SalesPerson> getAll(){

        return salesPersonRepository.getAll();
    }

    public Optional<SalesPerson> getSalesPersonById(int salesPersonId){

        return salesPersonRepository.getSalesPersonById(salesPersonId);

    }

    public Optional<SalesPerson> getSalesPersonByName(String name){

        return salesPersonRepository.getSalesPersonByName(name);
    }

    public SalesPerson saveSalesPerson(SalesPerson salesPerson){

        return salesPersonRepository.saveSalesPerson(salesPerson);
    }

    public boolean deleteSalesPerson(int salesPersonId){

        if ( salesPersonRepository.getSalesPersonById(salesPersonId).isPresent()){

            salesPersonRepository.deleteSalesPerson(salesPersonId);
            return true;
        }else{
            return false;
        }
    }
}
