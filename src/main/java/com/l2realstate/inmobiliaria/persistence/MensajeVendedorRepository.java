package com.l2realstate.inmobiliaria.persistence;


import com.l2realstate.inmobiliaria.domain.SalesPersonMessage;
import com.l2realstate.inmobiliaria.domain.repository.SalesPersonMessageRepository;
import com.l2realstate.inmobiliaria.persistence.crud.MensajeClienteCrudRepository;
import com.l2realstate.inmobiliaria.persistence.crud.MensajeVendedorCrudRepository;
import com.l2realstate.inmobiliaria.persistence.entity.MensajeVendedor;
import com.l2realstate.inmobiliaria.persistence.mapper.SalesPersonMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
public class MensajeVendedorRepository implements SalesPersonMessageRepository {

    @Autowired
    MensajeVendedorCrudRepository mensajeVendedorCrudRepository;

    @Autowired
    SalesPersonMessageMapper salesPersonMessageMapper;

    @Override
    public List<SalesPersonMessage> getAll() {

        List<MensajeVendedor> mensajesVendedor = (List<MensajeVendedor>) mensajeVendedorCrudRepository.findAll();
        return salesPersonMessageMapper.toSalesPersonMessages(mensajesVendedor);


    }

    @Override
    public Optional<List<SalesPersonMessage>> getByOperation(int operationId) {

        return  mensajeVendedorCrudRepository.findByIdOperacionOrderByFechaMVendedorAsc(operationId).map
                (a -> salesPersonMessageMapper.toSalesPersonMessages(a));

    }

    @Override
    public Optional<SalesPersonMessage> getSalesPersonMessage(int idSalesPersonMessage) {

       return mensajeVendedorCrudRepository.findById(idSalesPersonMessage).map
                (a -> salesPersonMessageMapper.toSalesPersonMessage(a));
    }

    @Override
    public SalesPersonMessage saveSalesPersonMessage(SalesPersonMessage salesPersonMessage) {

        MensajeVendedor mensajeVendedor = salesPersonMessageMapper.toMensajeVendedor(salesPersonMessage);
        mensajeVendedorCrudRepository.save(mensajeVendedor);
        return salesPersonMessage;
    }

    @Override
    public  void deleteSalesPersonMessage(int idSalesPersonMessage) {

        mensajeVendedorCrudRepository.deleteById(idSalesPersonMessage);

    }
}
