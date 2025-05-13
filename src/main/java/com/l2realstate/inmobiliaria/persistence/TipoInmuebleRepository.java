package com.l2realstate.inmobiliaria.persistence;

import com.l2realstate.inmobiliaria.domain.PropertyType;
import com.l2realstate.inmobiliaria.domain.repository.PropertyTypeRepository;
import com.l2realstate.inmobiliaria.persistence.crud.TipoInmuebleCrudRepository;
import com.l2realstate.inmobiliaria.persistence.entity.TipoInmueble;
import com.l2realstate.inmobiliaria.persistence.mapper.PropertyTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TipoInmuebleRepository implements PropertyTypeRepository {

    @Autowired
    TipoInmuebleCrudRepository tipoInmuebleCrudRepository;

    @Autowired
    PropertyTypeMapper propertyTypeMapper;

    @Override
    public List<PropertyType> getAll() {

        List<TipoInmueble> tipoInmuebles = (List<TipoInmueble>) tipoInmuebleCrudRepository.findAll();
        return propertyTypeMapper.toPropertyTypes(tipoInmuebles);
    }

    @Override
    public Optional<PropertyType> getPropertyTypeById(int propertyTypeId) {

        return tipoInmuebleCrudRepository.findById(propertyTypeId).map(a -> propertyTypeMapper.toPropertyType(a));

    }

    @Override
    public PropertyType savePropertyType(PropertyType propertyType) {

        TipoInmueble tipoInmueble = propertyTypeMapper.toTipoInmueble((propertyType));
        tipoInmuebleCrudRepository.save(tipoInmueble);
        return propertyType;
    }

    @Override
    public void deletePropertyType(int propertyTypeId) {

        tipoInmuebleCrudRepository.deleteById(propertyTypeId);

    }
}
