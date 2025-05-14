package com.l2realstate.inmobiliaria.persistence.mapper;

import com.l2realstate.inmobiliaria.domain.Service;
import com.l2realstate.inmobiliaria.persistence.entity.Servicio;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-14T09:04:03-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class ServiceMapperImpl implements ServiceMapper {

    @Override
    public Service toService(Servicio servicio) {
        if ( servicio == null ) {
            return null;
        }

        Service service = new Service();

        if ( servicio.getIdServicio() != null ) {
            service.setServiceId( servicio.getIdServicio() );
        }
        service.setService( servicio.getServicio() );

        return service;
    }

    @Override
    public List<Service> toServices(List<Servicio> servicios) {
        if ( servicios == null ) {
            return null;
        }

        List<Service> list = new ArrayList<Service>( servicios.size() );
        for ( Servicio servicio : servicios ) {
            list.add( toService( servicio ) );
        }

        return list;
    }

    @Override
    public Servicio toServicio(Service service) {
        if ( service == null ) {
            return null;
        }

        Servicio servicio = new Servicio();

        servicio.setIdServicio( service.getServiceId() );
        servicio.setServicio( service.getService() );

        return servicio;
    }

    @Override
    public List<Servicio> toServicios(List<Service> services) {
        if ( services == null ) {
            return null;
        }

        List<Servicio> list = new ArrayList<Servicio>( services.size() );
        for ( Service service : services ) {
            list.add( toServicio( service ) );
        }

        return list;
    }
}
