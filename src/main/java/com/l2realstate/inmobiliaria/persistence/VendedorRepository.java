package com.l2realstate.inmobiliaria.persistence;

import com.l2realstate.inmobiliaria.domain.SalesPerson;
import com.l2realstate.inmobiliaria.domain.repository.SalesPersonRepository;
import com.l2realstate.inmobiliaria.persistence.crud.VendedorCrudRepository;
import com.l2realstate.inmobiliaria.persistence.entity.Vendedor;
import com.l2realstate.inmobiliaria.persistence.mapper.SalesPersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VendedorRepository implements SalesPersonRepository {

    @Autowired
    VendedorCrudRepository vendedorCrudRepository;
    @Autowired
    SalesPersonMapper salesPersonMapper;


    @Override
    public List<SalesPerson> getAll() {

        List<Vendedor> vendedores =  (List<Vendedor>) vendedorCrudRepository.findAll();
        return salesPersonMapper.toSalesPersons(vendedores);

    }

    @Override
    public Optional<SalesPerson> getSalesPersonById(int salesPersonId) {

        return vendedorCrudRepository.findById(salesPersonId).map
                (a -> salesPersonMapper.toSalesPerson(a));

    }

    @Override
    public Optional<SalesPerson> getSalesPersonByName(String name) {

        return vendedorCrudRepository.findByNombreVendedor(name).map
                (a -> salesPersonMapper.toSalesPerson(a));
    }

    @Override
    public SalesPerson saveSalesPerson(SalesPerson salesPerson) {

        Vendedor vendedor = salesPersonMapper.toVendedor(salesPerson);
        vendedorCrudRepository.save(vendedor);
        return salesPerson;
    }

    @Override
    public void deleteSalesPerson(int salesPersonId) {

        vendedorCrudRepository.deleteById(salesPersonId);

    }
}
