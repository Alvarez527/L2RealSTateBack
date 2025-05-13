package com.l2realstate.inmobiliaria.domain.service;

import com.l2realstate.inmobiliaria.domain.Operation;
import com.l2realstate.inmobiliaria.domain.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperationService {

    @Autowired
    OperationRepository operationRepository;

    public List<Operation> getAll(){
        return operationRepository.getAll();

    }

    public Optional<Operation> getOperationById(int operationId){

        return operationRepository.getOperationById(operationId);
    }

    public Operation saveOperation(Operation operation){

         return operationRepository.saveOperation(operation);
    }

    public boolean deleteOperation(int operationId){

        if( operationRepository.getOperationById(operationId).isPresent()){

            operationRepository.deleteOperation(operationId);
            return true;
        }else{
            return false;
        }
    }
}
