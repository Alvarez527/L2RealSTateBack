package com.l2realstate.inmobiliaria.persistence;

import com.l2realstate.inmobiliaria.domain.Operation;
import com.l2realstate.inmobiliaria.domain.repository.OperationRepository;
import com.l2realstate.inmobiliaria.persistence.crud.OperacionCrudRepository;
import com.l2realstate.inmobiliaria.persistence.entity.Operacion;
import com.l2realstate.inmobiliaria.persistence.mapper.OperationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OperacionRepository implements OperationRepository {
    @Autowired
    OperacionCrudRepository operacionCrudRepository;

    @Autowired
    OperationMapper operationMapper;


    @Override
    public List<Operation> getAll() {
        List<Operacion> operaciones = (List<Operacion>) operacionCrudRepository.findAll();
        return operationMapper.toOperations(operaciones);
    }

    @Override
    public Optional<Operation> getOperationById(int operationId) {
        return operacionCrudRepository.findById(operationId).map(a -> operationMapper.toOperation(a));
    }

    @Override
    public Operation saveOperation(Operation operation) {
        Operacion operacion = operationMapper.toOperacion(operation);
        operacionCrudRepository.save(operacion);
        return operation;
    }

    @Override
    public void deleteOperation(int operationId) {

        operacionCrudRepository.deleteById(operationId);

    }
}
