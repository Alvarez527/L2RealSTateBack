package com.l2realstate.inmobiliaria.domain.repository;

import com.l2realstate.inmobiliaria.domain.Operation;

import java.util.List;
import java.util.Optional;

public interface OperationRepository {

    public List<Operation> getAll();

    public Optional<Operation> getOperationById(int operationId);

    public Operation saveOperation(Operation operation);

    public void deleteOperation(int operationId);
}
