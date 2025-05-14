package com.l2realstate.inmobiliaria.domain.repository;

import com.l2realstate.inmobiliaria.domain.Service;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository {

    public List<Service> getAll();

    public Optional<Service> getServiceById(int serviceId);


    public Service saveService(Service service);

    public void deleteService(int serviceId);

}

