package com.l2realstate.inmobiliaria.persistence.mapper;

import com.l2realstate.inmobiliaria.domain.Service;
import com.l2realstate.inmobiliaria.domain.State;
import com.l2realstate.inmobiliaria.persistence.entity.Estado;
import com.l2realstate.inmobiliaria.persistence.entity.Servicio;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServiceMapper {

    @Mappings({

            @Mapping(source = "idServicio", target = "serviceId"),
            @Mapping(source = "servicio", target = "service")

    })

    Service toService(Servicio servicio);
    List<Service> toServices(List<Servicio> servicios);

    @InheritInverseConfiguration
    Servicio toServicio(Service service);
    List<Servicio> toServicios(List<Service> services);
}


