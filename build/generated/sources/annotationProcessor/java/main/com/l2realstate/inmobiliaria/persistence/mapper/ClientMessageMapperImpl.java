package com.l2realstate.inmobiliaria.persistence.mapper;

import com.l2realstate.inmobiliaria.domain.ClientMessage;
import com.l2realstate.inmobiliaria.persistence.entity.MensajeCliente;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-14T12:05:40-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class ClientMessageMapperImpl implements ClientMessageMapper {

    @Override
    public ClientMessage toClientMessage(MensajeCliente mensajeCliente) {
        if ( mensajeCliente == null ) {
            return null;
        }

        ClientMessage clientMessage = new ClientMessage();

        if ( mensajeCliente.getIdMensajeCliente() != null ) {
            clientMessage.setIdClientMessage( mensajeCliente.getIdMensajeCliente() );
        }
        if ( mensajeCliente.getIdOperacion() != null ) {
            clientMessage.setOperationId( mensajeCliente.getIdOperacion() );
        }
        clientMessage.setClientMessageDate( mensajeCliente.getFechaMCliente() );
        clientMessage.setMessage( mensajeCliente.getMensaje() );

        return clientMessage;
    }

    @Override
    public List<ClientMessage> toClientsMessage(List<MensajeCliente> mensajesCliente) {
        if ( mensajesCliente == null ) {
            return null;
        }

        List<ClientMessage> list = new ArrayList<ClientMessage>( mensajesCliente.size() );
        for ( MensajeCliente mensajeCliente : mensajesCliente ) {
            list.add( toClientMessage( mensajeCliente ) );
        }

        return list;
    }

    @Override
    public MensajeCliente toMensajeCliente(ClientMessage clientMessage) {
        if ( clientMessage == null ) {
            return null;
        }

        MensajeCliente mensajeCliente = new MensajeCliente();

        mensajeCliente.setIdMensajeCliente( clientMessage.getIdClientMessage() );
        mensajeCliente.setIdOperacion( clientMessage.getOperationId() );
        mensajeCliente.setFechaMCliente( clientMessage.getClientMessageDate() );
        mensajeCliente.setMensaje( clientMessage.getMessage() );

        return mensajeCliente;
    }

    @Override
    public List<MensajeCliente> toMensajesCliente(List<ClientMessage> clientMessages) {
        if ( clientMessages == null ) {
            return null;
        }

        List<MensajeCliente> list = new ArrayList<MensajeCliente>( clientMessages.size() );
        for ( ClientMessage clientMessage : clientMessages ) {
            list.add( toMensajeCliente( clientMessage ) );
        }

        return list;
    }
}
