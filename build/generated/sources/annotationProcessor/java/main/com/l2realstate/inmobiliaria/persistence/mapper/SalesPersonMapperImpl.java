package com.l2realstate.inmobiliaria.persistence.mapper;

import com.l2realstate.inmobiliaria.domain.SalesPerson;
import com.l2realstate.inmobiliaria.persistence.entity.Vendedor;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-31T20:43:55-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class SalesPersonMapperImpl implements SalesPersonMapper {

    @Override
    public SalesPerson toSalesPerson(Vendedor vendedor) {
        if ( vendedor == null ) {
            return null;
        }

        SalesPerson salesPerson = new SalesPerson();

        if ( vendedor.getIdVendedor() != null ) {
            salesPerson.setSalesPersonId( vendedor.getIdVendedor() );
        }
        salesPerson.setSalesPersonName( vendedor.getNombreVendedor() );
        salesPerson.setSalesPersonMobileNumber( vendedor.getTelefonoVendedor() );
        salesPerson.setSalesPersonEmail( vendedor.getEmailVendedor() );

        return salesPerson;
    }

    @Override
    public List<SalesPerson> toSalesPersons(List<Vendedor> vendedores) {
        if ( vendedores == null ) {
            return null;
        }

        List<SalesPerson> list = new ArrayList<SalesPerson>( vendedores.size() );
        for ( Vendedor vendedor : vendedores ) {
            list.add( toSalesPerson( vendedor ) );
        }

        return list;
    }

    @Override
    public Vendedor toVendedor(SalesPerson salesPerson) {
        if ( salesPerson == null ) {
            return null;
        }

        Vendedor vendedor = new Vendedor();

        vendedor.setIdVendedor( salesPerson.getSalesPersonId() );
        vendedor.setNombreVendedor( salesPerson.getSalesPersonName() );
        vendedor.setTelefonoVendedor( salesPerson.getSalesPersonMobileNumber() );
        vendedor.setEmailVendedor( salesPerson.getSalesPersonEmail() );

        return vendedor;
    }

    @Override
    public List<Vendedor> toVendedores(List<SalesPerson> salesPersons) {
        if ( salesPersons == null ) {
            return null;
        }

        List<Vendedor> list = new ArrayList<Vendedor>( salesPersons.size() );
        for ( SalesPerson salesPerson : salesPersons ) {
            list.add( toVendedor( salesPerson ) );
        }

        return list;
    }
}
