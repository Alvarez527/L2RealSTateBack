package com.l2realstate.inmobiliaria.domain.repository;

import com.l2realstate.inmobiliaria.domain.Operation;
import com.l2realstate.inmobiliaria.domain.Property;

import java.util.List;
import java.util.Optional;

public interface PropertyRepository {

    public List<Property> getAll();

    public Optional<Property> getPropertyById(int propertyId);

    public Property saveProperty(Property property);

    public List<Operation> getOperations(int propertyId);

    public Boolean deleteProperty(int propertyId);
}
