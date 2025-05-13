package com.l2realstate.inmobiliaria.persistence;

import com.l2realstate.inmobiliaria.domain.PropertiesService;
import com.l2realstate.inmobiliaria.domain.Service;
import com.l2realstate.inmobiliaria.domain.repository.PropertiesServiceRepository;
import com.l2realstate.inmobiliaria.persistence.crud.InmueblesServicioCrudRepository;
import com.l2realstate.inmobiliaria.persistence.entity.InmueblesServicio;
import com.l2realstate.inmobiliaria.persistence.entity.Servicio;
import com.l2realstate.inmobiliaria.persistence.mapper.PropertiesServiceMapper;
import com.l2realstate.inmobiliaria.persistence.mapper.ServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InmueblesServicioRepository implements PropertiesServiceRepository {

    @Autowired
    InmueblesServicioCrudRepository inmueblesServicioCrudRepository;
    @Autowired
    PropertiesServiceMapper propertiesServiceMapper;
    ServiceMapper serviceMapper;
    @Override
    public List<PropertiesService> getAll() {

        List<InmueblesServicio> inmueblesServicios = (List<InmueblesServicio>) inmueblesServicioCrudRepository.findAll();
        return propertiesServiceMapper.toPropertiesServices(inmueblesServicios);

    }

    @Override
    public Optional<List<PropertiesService>> findByPropertyPropertyId(int propertyId) {

        Optional<List<InmueblesServicio>> servicios = inmueblesServicioCrudRepository.findByInmueble_idInmueble(propertyId);
        return servicios.map(a -> propertiesServiceMapper.toPropertiesServices(a));
    }


    @Override
    public PropertiesService savePropertiesService(PropertiesService propertiesService) {

        InmueblesServicio inmueblesServicio = propertiesServiceMapper.toInmueblesServicio(propertiesService);
        inmueblesServicioCrudRepository.save(inmueblesServicio);
        return propertiesService;
    }

    @Override
    public Boolean deletePropertiesService(PropertiesService propertiesService) {

        try {

            InmueblesServicio inmueblesServicio = propertiesServiceMapper.toInmueblesServicio(propertiesService);

            if (inmueblesServicio != null){

                inmueblesServicioCrudRepository.delete(inmueblesServicio);
                return true;
            }else{
                return false;
            }

        }catch(Exception e){

            System.out.println(e);
            return false;

        }

    }
}
