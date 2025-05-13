package com.l2realstate.inmobiliaria.persistence;

import com.l2realstate.inmobiliaria.domain.Service;
import com.l2realstate.inmobiliaria.domain.repository.ServiceRepository;
import com.l2realstate.inmobiliaria.persistence.crud.ServicioCrudRepository;
import com.l2realstate.inmobiliaria.persistence.entity.Servicio;
import com.l2realstate.inmobiliaria.persistence.mapper.ServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ServicioRepository implements ServiceRepository {

    @Autowired
    ServicioCrudRepository servicioCrudRepository;
    @Autowired
    ServiceMapper serviceMapper;

    @Override
    public List<Service> getAll(){

        List<Servicio> servicios = (List<Servicio>) servicioCrudRepository.findAll();

        return serviceMapper.toServices(servicios);
    }
    @Override
    public Optional<Service> getServiceById(int serviceId) {

        return servicioCrudRepository.findById(serviceId).map(a -> serviceMapper.toService(a));
    }



    @Override
    public Service saveService(Service service) {

        Servicio servicio = serviceMapper.toServicio(service);
        servicioCrudRepository.save(servicio);
        return service;
    }

    @Override
    public void deleteService(int serviceId) {

        servicioCrudRepository.deleteById(serviceId);

    }
}
