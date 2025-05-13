package com.l2realstate.inmobiliaria.domain.service;


import com.l2realstate.inmobiliaria.domain.PropertyType;
import com.l2realstate.inmobiliaria.domain.repository.PropertyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyTypeService {

    @Autowired
    PropertyTypeRepository propertyTypeRepository;

    public List<PropertyType> getAll(){

        return propertyTypeRepository.getAll();
    }
    public Optional<PropertyType> getPropertyTypeById(int propertyTypeId){

        return propertyTypeRepository.getPropertyTypeById(propertyTypeId);

    }

    public PropertyType savePropertyType(PropertyType propertyType){

        return propertyTypeRepository.savePropertyType(propertyType);
    }

    public boolean deletePropertyType(int propertyTypeId){

        if ( propertyTypeRepository.getPropertyTypeById(propertyTypeId).isPresent()){

            propertyTypeRepository.deletePropertyType(propertyTypeId);
            return true;
        }else{
            return false;
        }
    }

}

