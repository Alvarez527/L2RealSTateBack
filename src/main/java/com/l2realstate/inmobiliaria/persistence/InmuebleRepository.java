package com.l2realstate.inmobiliaria.persistence;

import com.l2realstate.inmobiliaria.domain.Operation;
import com.l2realstate.inmobiliaria.domain.Property;
import com.l2realstate.inmobiliaria.domain.repository.PropertyRepository;
import com.l2realstate.inmobiliaria.persistence.crud.InmuebleCrudRepository;
import com.l2realstate.inmobiliaria.persistence.entity.Inmueble;
import com.l2realstate.inmobiliaria.persistence.mapper.PropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InmuebleRepository implements PropertyRepository {

    @Autowired
    InmuebleCrudRepository inmuebleCrudRepository;

    @Autowired
    PropertyMapper propertyMapper;
    @Override
    public List<Property> getAll() {

        List<Inmueble> inmuebles = (List<Inmueble>) inmuebleCrudRepository.findAll();
        return propertyMapper.toProperties(inmuebles);

    }

    @Override
    public Optional<Property> getPropertyById(int propertyId) {
        return inmuebleCrudRepository.findById(propertyId).map(a -> propertyMapper.toProperty(a));
    }

    @Override
    public Property saveProperty(Property property) {
        Inmueble inmueble = propertyMapper.toInmueble(property);
        inmuebleCrudRepository.save(inmueble);
        return property;
    }

    @Override
    public List<Operation> getOperations(int propertyId) {

        Optional<Inmueble> inmueble = inmuebleCrudRepository.findById(propertyId);

        return inmueble.map(value -> propertyMapper.toProperty(value).getOperationList()).orElse(null);
    }

    @Override
    public Boolean deleteProperty(int propertyId) {

        if (getPropertyById(propertyId).isPresent()) {
            inmuebleCrudRepository.deleteById(propertyId);
            return true;
        }else{
            return false;
        }

    }
}
