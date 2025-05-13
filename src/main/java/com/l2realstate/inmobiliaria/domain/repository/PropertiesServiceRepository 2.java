package com.l2realstate.inmobiliaria.domain.repository;

import com.l2realstate.inmobiliaria.domain.PropertiesService;
import com.l2realstate.inmobiliaria.domain.Service;

import java.util.List;
import java.util.Optional;

public interface PropertiesServiceRepository {

    public List<PropertiesService> getAll();

    public Optional<List<PropertiesService>> findByPropertyPropertyId(int propertyId);


    public PropertiesService savePropertiesService(PropertiesService propertiesService);

    public Boolean deletePropertiesService(PropertiesService propertiesService);

}


