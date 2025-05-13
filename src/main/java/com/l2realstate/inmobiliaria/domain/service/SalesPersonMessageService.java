package com.l2realstate.inmobiliaria.domain.service;


import com.l2realstate.inmobiliaria.domain.SalesPersonMessage;
import com.l2realstate.inmobiliaria.domain.repository.SalesPersonMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesPersonMessageService {

    @Autowired
    SalesPersonMessageRepository salesPersonMessageRepository;

    public List<SalesPersonMessage> getAll(){

        return salesPersonMessageRepository.getAll();
    }

    public Optional<List<SalesPersonMessage>> getByOperation(int operationId){

        return salesPersonMessageRepository.getByOperation(operationId);
    }

    public Optional<SalesPersonMessage> salesPersonMessage(int idSalesPersonMessage) {

        return salesPersonMessageRepository.getSalesPersonMessage(idSalesPersonMessage);
    }

    public SalesPersonMessage saveSalesPersonMessage(SalesPersonMessage salesPersonMessage){

        salesPersonMessageRepository.saveSalesPersonMessage(salesPersonMessage);
        return salesPersonMessage;
    }

    public boolean deleteSalesPersonMessage(int idSalesPersonMessage){

        if (salesPersonMessageRepository.getSalesPersonMessage(idSalesPersonMessage).isPresent()){

            salesPersonMessageRepository.deleteSalesPersonMessage(idSalesPersonMessage);
            return true;
        }else{
            return false;
        }
    }



}

