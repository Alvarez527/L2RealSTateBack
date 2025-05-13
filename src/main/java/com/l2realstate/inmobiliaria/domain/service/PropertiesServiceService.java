package com.l2realstate.inmobiliaria.domain.service;

import com.l2realstate.inmobiliaria.domain.PropertiesService;
import com.l2realstate.inmobiliaria.domain.repository.PropertiesServiceRepository;
import com.l2realstate.inmobiliaria.persistence.entity.InmueblesServicio;
import com.l2realstate.inmobiliaria.persistence.entity.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropertiesServiceService {

    @Autowired
    PropertiesServiceRepository propertiesServiceRepository;

    public List<PropertiesService> getAll(){

        return propertiesServiceRepository.getAll();
    }

    public Optional<List<com.l2realstate.inmobiliaria.domain.Service>> getServicesByProperty(int propertyId){


        if(propertiesServiceRepository.findByPropertyPropertyId(propertyId).isPresent()){

            List<com.l2realstate.inmobiliaria.domain.Service> services =   propertiesServiceRepository.findByPropertyPropertyId(propertyId).get().stream()
                    .map(PropertiesService::getService)
                    .toList();

            return Optional.of(services);

        }else{
            return Optional.empty();
        }
    }

    public PropertiesService savePropertyService(PropertiesService propertiesService){

        return propertiesServiceRepository.savePropertiesService(propertiesService);
    }


    public Boolean deletePropertyService(PropertiesService propertiesService){

        return propertiesServiceRepository.deletePropertiesService(propertiesService);

    }

}

/*



    public void deletePropertyService(PropertyService propertyService);*/
