package com.l2realstate.inmobiliaria.persistence.mapper;

import com.l2realstate.inmobiliaria.domain.PropertiesService;
import com.l2realstate.inmobiliaria.domain.Property;
import com.l2realstate.inmobiliaria.domain.Residential;
import com.l2realstate.inmobiliaria.domain.Service;
import com.l2realstate.inmobiliaria.persistence.entity.*;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PropertyMapper.class, ServiceMapper.class})
public interface PropertiesServiceMapper {

    @Mappings({

                    @Mapping(source="id.idInmueble", target="propertyId"),
                    @Mapping(source = "id.idServicio", target="serviceId")
    })
    PropertiesService toPropertiesService(InmueblesServicio inmueblesServicio);
    List<PropertiesService> toPropertiesServices(List<InmueblesServicio> inmueblesServicios);


    @InheritInverseConfiguration
    InmueblesServicio toInmueblesServicio(PropertiesService  propertiesService);
    List<InmueblesServicio> toInmuebleServicios(List<PropertiesService> propertiesServices);

}


