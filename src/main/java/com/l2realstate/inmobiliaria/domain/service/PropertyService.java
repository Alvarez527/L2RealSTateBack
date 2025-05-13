package com.l2realstate.inmobiliaria.domain.service;

import com.l2realstate.inmobiliaria.domain.Operation;
import com.l2realstate.inmobiliaria.domain.Property;
import com.l2realstate.inmobiliaria.domain.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    public List<Property> getAll(){

        return propertyRepository.getAll();
    }

    public Optional<Property> getPropertyById(int propertyId){

        return propertyRepository.getPropertyById(propertyId);
    }

    public Property saveProperty(Property property){

        return propertyRepository.saveProperty(property);
    }

    public List<Operation> getOperations(int propertyId){

        return propertyRepository.getOperations(propertyId);
    }

    public boolean deleteProperty(int propertyId){

        if( propertyRepository.getPropertyById(propertyId).isPresent()){
            propertyRepository.deleteProperty(propertyId);
            return true;
        }else{
            return false;
        }
    }
}