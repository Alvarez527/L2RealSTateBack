package com.l2realstate.inmobiliaria.persistence.mapper;


import com.l2realstate.inmobiliaria.domain.ClientMessage;
import com.l2realstate.inmobiliaria.persistence.entity.MensajeCliente;
import jakarta.persistence.Column;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMessageMapper {

    //Mediante esta configuracion se tiene una funcion para convertir entre entidades
    //que se encuentran en las bases de datos y las del dominio
    @Mappings({
            @Mapping(source="idMensajeCliente", target="idClientMessage"),
            @Mapping(source="idOperacion", target="operationId"),
            @Mapping(source="fechaMCliente", target="clientMessageDate"),
            @Mapping(source="mensaje", target="message")

    })
    ClientMessage toClientMessage(MensajeCliente mensajeCliente);
    List<ClientMessage> toClientsMessage(List<MensajeCliente> mensajesCliente);

    @InheritInverseConfiguration //Para tener una conversion inversa
    MensajeCliente toMensajeCliente(ClientMessage clientMessage);
    List<MensajeCliente> toMensajesCliente(List<ClientMessage> clientMessages);
}
