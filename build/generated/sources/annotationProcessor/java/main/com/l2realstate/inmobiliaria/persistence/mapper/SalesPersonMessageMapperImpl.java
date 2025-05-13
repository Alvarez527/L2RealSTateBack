package com.l2realstate.inmobiliaria.persistence.mapper;

import com.l2realstate.inmobiliaria.domain.SalesPersonMessage;
import com.l2realstate.inmobiliaria.persistence.entity.MensajeVendedor;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-31T20:43:56-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class SalesPersonMessageMapperImpl implements SalesPersonMessageMapper {

    @Override
    public SalesPersonMessage toSalesPersonMessage(MensajeVendedor mensajeVendedor) {
        if ( mensajeVendedor == null ) {
            return null;
        }

        SalesPersonMessage salesPersonMessage = new SalesPersonMessage();

        if ( mensajeVendedor.getIdMensajeVendedor() != null ) {
            salesPersonMessage.setIdSalesPersonMessage( mensajeVendedor.getIdMensajeVendedor() );
        }
        if ( mensajeVendedor.getIdOperacion() != null ) {
            salesPersonMessage.setOperationId( mensajeVendedor.getIdOperacion() );
        }
        salesPersonMessage.setSalesPersonMessageDate( mensajeVendedor.getFechaMVendedor() );
        salesPersonMessage.setSalesPersonMessage( mensajeVendedor.getMensajeVendedor() );

        return salesPersonMessage;
    }

    @Override
    public List<SalesPersonMessage> toSalesPersonMessages(List<MensajeVendedor> mensajesVendedor) {
        if ( mensajesVendedor == null ) {
            return null;
        }

        List<SalesPersonMessage> list = new ArrayList<SalesPersonMessage>( mensajesVendedor.size() );
        for ( MensajeVendedor mensajeVendedor : mensajesVendedor ) {
            list.add( toSalesPersonMessage( mensajeVendedor ) );
        }

        return list;
    }

    @Override
    public MensajeVendedor toMensajeVendedor(SalesPersonMessage salesPersonMessage) {
        if ( salesPersonMessage == null ) {
            return null;
        }

        MensajeVendedor mensajeVendedor = new MensajeVendedor();

        mensajeVendedor.setIdMensajeVendedor( salesPersonMessage.getIdSalesPersonMessage() );
        mensajeVendedor.setIdOperacion( salesPersonMessage.getOperationId() );
        mensajeVendedor.setFechaMVendedor( salesPersonMessage.getSalesPersonMessageDate() );
        mensajeVendedor.setMensajeVendedor( salesPersonMessage.getSalesPersonMessage() );

        return mensajeVendedor;
    }

    @Override
    public List<MensajeVendedor> toMensajesVendedor(List<SalesPersonMessage> salesPersonMessages) {
        if ( salesPersonMessages == null ) {
            return null;
        }

        List<MensajeVendedor> list = new ArrayList<MensajeVendedor>( salesPersonMessages.size() );
        for ( SalesPersonMessage salesPersonMessage : salesPersonMessages ) {
            list.add( toMensajeVendedor( salesPersonMessage ) );
        }

        return list;
    }
}
