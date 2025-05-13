package com.l2realstate.inmobiliaria.persistence.mapper;

import com.l2realstate.inmobiliaria.domain.SalesPerson;
import com.l2realstate.inmobiliaria.persistence.entity.Vendedor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SalesPersonMapper {

    @Mappings({

            @Mapping(source ="idVendedor", target="salesPersonId"),
            @Mapping(source ="nombreVendedor", target="salesPersonName"),
            @Mapping(source ="telefonoVendedor", target="salesPersonMobileNumber"),
            @Mapping(source ="emailVendedor", target="salesPersonEmail")
    })
    SalesPerson toSalesPerson(Vendedor vendedor);
    List<SalesPerson> toSalesPersons(List<Vendedor> vendedores);

    @InheritInverseConfiguration
    Vendedor toVendedor(SalesPerson salesPerson);
    List<Vendedor> toVendedores(List<SalesPerson> salesPersons);
}


