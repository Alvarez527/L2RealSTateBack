package com.l2realstate.inmobiliaria.domain.repository;

import com.l2realstate.inmobiliaria.domain.SalesPerson;

import java.util.List;
import java.util.Optional;

public interface SalesPersonRepository {

    public List<SalesPerson> getAll();

    public Optional<SalesPerson> getSalesPersonById(int salesPersonId);

    public Optional<SalesPerson> getSalesPersonByName(String name);

    public SalesPerson saveSalesPerson(SalesPerson salesPerson);

    public void deleteSalesPerson(int salesPersonId);

}



