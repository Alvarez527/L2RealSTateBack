package com.l2realstate.inmobiliaria.persistence.mapper;


import com.l2realstate.inmobiliaria.domain.PropertiesService;
import com.l2realstate.inmobiliaria.persistence.entity.InmueblesServicio;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import java.util.List;

@Mapper(componentModel = "spring", uses = {PropertyMapper.class, ServiceMapper.class})
public interface PropertiesServiceMapper {

    @Mappings({

            @Mapping(source="descripcionServicio", target="serviceDescription"),
            @Mapping(source="inmueble", target="property"),
            @Mapping(source="servicio", target="service"),
    })
    PropertiesService toPropertiesService(InmueblesServicio inmueblesServicio);
    List<PropertiesService> toPropertiesServices(List<InmueblesServicio> inmueblesServicios);

    @InheritInverseConfiguration
    InmueblesServicio toInmueblesServicio(PropertiesService propertiesService);
    List<InmueblesServicio> toInmueblesServicios(List<PropertiesService> propertiesServices);

}

