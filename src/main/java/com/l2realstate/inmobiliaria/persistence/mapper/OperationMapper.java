package com.l2realstate.inmobiliaria.persistence.mapper;

import com.l2realstate.inmobiliaria.domain.Operation;
import com.l2realstate.inmobiliaria.domain.Property;
import com.l2realstate.inmobiliaria.persistence.entity.*;
import jakarta.persistence.*;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class, SalesPersonMapper.class, SalesPersonMessageMapper.class, ClientMessageMapper.class})
public interface OperationMapper {

    @Mappings({

            @Mapping(source = "idOperacion", target = "operationId"),
            @Mapping(source = "idInmueble", target = "propertyId"),
            @Mapping(source = "tipoOperacion", target = "operationType"),
            @Mapping(source = "idCliente", target = "customerId"),
            @Mapping(source = "idVendedor", target = "salesPersonId"),
            @Mapping(source = "cliente", target = "customer"),
            @Mapping(source = "vendedor", target = "salesPerson"),
            @Mapping(source = "mensajesVendedor", target = "salesPersonMessageList"),
            @Mapping(source = "mensajesCliente", target = "clientMessageList"),
            @Mapping(target = "property", ignore = true)
    })
    Operation toOperation(Operacion operacion);
    List<Operation> toOperations(List<Operacion> operaciones);

    @InheritInverseConfiguration

    Operacion toOperacion(Operation operation);
    List<Operacion> toOperaciones(List<Operation> operaciones);


}



