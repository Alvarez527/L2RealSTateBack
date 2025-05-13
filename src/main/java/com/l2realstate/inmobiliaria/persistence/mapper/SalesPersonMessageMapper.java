package com.l2realstate.inmobiliaria.persistence.mapper;

import com.l2realstate.inmobiliaria.domain.ClientMessage;
import com.l2realstate.inmobiliaria.domain.SalesPersonMessage;
import com.l2realstate.inmobiliaria.persistence.entity.MensajeCliente;
import com.l2realstate.inmobiliaria.persistence.entity.MensajeVendedor;
import jakarta.persistence.Column;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface SalesPersonMessageMapper {

    @Mappings({
            //Se colocan los mappers conforme a las propiedades de la clase target y source
            //Target son las clases de destino en el dominio y source son las mapeadas en el package de persistencia
            @Mapping(source="idMensajeVendedor", target="idSalesPersonMessage"),
            @Mapping(source="idOperacion", target="operationId"),
            @Mapping(source="fechaMVendedor", target="salesPersonMessageDate"),
            @Mapping(source="mensajeVendedor", target="salesPersonMessage"),

    })
    SalesPersonMessage toSalesPersonMessage(MensajeVendedor mensajeVendedor);
    List<SalesPersonMessage> toSalesPersonMessages(List<MensajeVendedor> mensajesVendedor);


    @InheritInverseConfiguration
    MensajeVendedor toMensajeVendedor(SalesPersonMessage salesPersonMessage);
    List<MensajeVendedor> toMensajesVendedor(List<SalesPersonMessage> salesPersonMessages);


}
