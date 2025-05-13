package com.l2realstate.inmobiliaria.domain.service;

import com.l2realstate.inmobiliaria.domain.Service;
import com.l2realstate.inmobiliaria.domain.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


@org.springframework.stereotype.Service
public class ServiceService {
    @Autowired
    ServiceRepository serviceRepository;

    public List<Service> getAll(){

        return serviceRepository.getAll();
    }
    public Optional<Service> getServiceById(int serviceId){


        return serviceRepository.getServiceById(serviceId);

    }


    public Service saveService(Service service){

        return serviceRepository.saveService(service);
    }

    public boolean deleteService(int serviceId){

        if( serviceRepository.getServiceById(serviceId).isPresent()){

            serviceRepository.deleteService(serviceId);
            return true;
        }else{

            return false;
        }


    }



}

/*
    public Service saveService(Service service);

    public void deleteService(int serviceId);*/
