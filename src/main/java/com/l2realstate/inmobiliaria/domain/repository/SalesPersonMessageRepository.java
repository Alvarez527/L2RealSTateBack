package com.l2realstate.inmobiliaria.domain.repository;

import com.l2realstate.inmobiliaria.domain.ClientMessage;
import com.l2realstate.inmobiliaria.domain.SalesPersonMessage;

import java.util.List;
import java.util.Optional;

public interface SalesPersonMessageRepository {

    public List<SalesPersonMessage> getAll();

    public Optional<List<SalesPersonMessage>> getByOperation(int operationId);

    public Optional<SalesPersonMessage> getSalesPersonMessage(int idSalesPersonMessage);

    public SalesPersonMessage saveSalesPersonMessage(SalesPersonMessage salesPersonMessage);

    public void deleteSalesPersonMessage(int idSalesPersonMessage);


}


