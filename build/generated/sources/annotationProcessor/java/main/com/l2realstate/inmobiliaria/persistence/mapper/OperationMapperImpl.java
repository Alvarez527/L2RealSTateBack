package com.l2realstate.inmobiliaria.persistence.mapper;

import com.l2realstate.inmobiliaria.domain.Operation;
import com.l2realstate.inmobiliaria.persistence.entity.Operacion;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-31T20:43:56-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class OperationMapperImpl implements OperationMapper {

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private SalesPersonMapper salesPersonMapper;
    @Autowired
    private SalesPersonMessageMapper salesPersonMessageMapper;
    @Autowired
    private ClientMessageMapper clientMessageMapper;

    @Override
    public Operation toOperation(Operacion operacion) {
        if ( operacion == null ) {
            return null;
        }

        Operation operation = new Operation();

        if ( operacion.getIdOperacion() != null ) {
            operation.setOperationId( operacion.getIdOperacion() );
        }
        if ( operacion.getIdInmueble() != null ) {
            operation.setPropertyId( operacion.getIdInmueble() );
        }
        operation.setOperationType( operacion.getTipoOperacion() );
        if ( operacion.getIdCliente() != null ) {
            operation.setCustomerId( operacion.getIdCliente() );
        }
        if ( operacion.getIdVendedor() != null ) {
            operation.setSalesPersonId( operacion.getIdVendedor() );
        }
        operation.setCustomer( customerMapper.toCustomer( operacion.getCliente() ) );
        operation.setSalesPerson( salesPersonMapper.toSalesPerson( operacion.getVendedor() ) );
        operation.setSalesPersonMessageList( salesPersonMessageMapper.toSalesPersonMessages( operacion.getMensajesVendedor() ) );
        operation.setClientMessageList( clientMessageMapper.toClientsMessage( operacion.getMensajesCliente() ) );

        return operation;
    }

    @Override
    public List<Operation> toOperations(List<Operacion> operaciones) {
        if ( operaciones == null ) {
            return null;
        }

        List<Operation> list = new ArrayList<Operation>( operaciones.size() );
        for ( Operacion operacion : operaciones ) {
            list.add( toOperation( operacion ) );
        }

        return list;
    }

    @Override
    public Operacion toOperacion(Operation operation) {
        if ( operation == null ) {
            return null;
        }

        Operacion operacion = new Operacion();

        operacion.setIdOperacion( operation.getOperationId() );
        operacion.setIdInmueble( operation.getPropertyId() );
        operacion.setTipoOperacion( operation.getOperationType() );
        operacion.setIdCliente( operation.getCustomerId() );
        operacion.setIdVendedor( operation.getSalesPersonId() );
        operacion.setCliente( customerMapper.toCliente( operation.getCustomer() ) );
        operacion.setVendedor( salesPersonMapper.toVendedor( operation.getSalesPerson() ) );
        operacion.setMensajesVendedor( salesPersonMessageMapper.toMensajesVendedor( operation.getSalesPersonMessageList() ) );
        operacion.setMensajesCliente( clientMessageMapper.toMensajesCliente( operation.getClientMessageList() ) );

        return operacion;
    }

    @Override
    public List<Operacion> toOperaciones(List<Operation> operaciones) {
        if ( operaciones == null ) {
            return null;
        }

        List<Operacion> list = new ArrayList<Operacion>( operaciones.size() );
        for ( Operation operation : operaciones ) {
            list.add( toOperacion( operation ) );
        }

        return list;
    }
}
