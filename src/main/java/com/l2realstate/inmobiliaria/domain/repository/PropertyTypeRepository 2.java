package com.l2realstate.inmobiliaria.domain.repository;

import com.l2realstate.inmobiliaria.domain.PropertyType;

import java.util.List;
import java.util.Optional;

public interface PropertyTypeRepository {

    public List<PropertyType> getAll();
    public Optional<PropertyType> getPropertyTypeById(int propertyTypeId);

    public PropertyType savePropertyType(PropertyType propertyType);

    public void deletePropertyType(int PropertyType);


}
