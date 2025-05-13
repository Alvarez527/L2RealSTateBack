package com.l2realstate.inmobiliaria.persistence.mapper;

import com.l2realstate.inmobiliaria.domain.PropertiesService;
import com.l2realstate.inmobiliaria.persistence.entity.InmueblesServicio;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-31T20:43:56-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class PropertiesServiceMapperImpl implements PropertiesServiceMapper {

    @Autowired
    private PropertyMapper propertyMapper;
    @Autowired
    private ServiceMapper serviceMapper;

    @Override
    public PropertiesService toPropertiesService(InmueblesServicio inmueblesServicio) {
        if ( inmueblesServicio == null ) {
            return null;
        }

        PropertiesService propertiesService = new PropertiesService();

        propertiesService.setServiceDescription( inmueblesServicio.getDescripcionServicio() );
        propertiesService.setProperty( propertyMapper.toProperty( inmueblesServicio.getInmueble() ) );
        propertiesService.setService( serviceMapper.toService( inmueblesServicio.getServicio() ) );

        return propertiesService;
    }

    @Override
    public List<PropertiesService> toPropertiesServices(List<InmueblesServicio> inmueblesServicios) {
        if ( inmueblesServicios == null ) {
            return null;
        }

        List<PropertiesService> list = new ArrayList<PropertiesService>( inmueblesServicios.size() );
        for ( InmueblesServicio inmueblesServicio : inmueblesServicios ) {
            list.add( toPropertiesService( inmueblesServicio ) );
        }

        return list;
    }

    @Override
    public InmueblesServicio toInmueblesServicio(PropertiesService propertiesService) {
        if ( propertiesService == null ) {
            return null;
        }

        InmueblesServicio inmueblesServicio = new InmueblesServicio();

        inmueblesServicio.setDescripcionServicio( propertiesService.getServiceDescription() );
        inmueblesServicio.setInmueble( propertyMapper.toInmueble( propertiesService.getProperty() ) );
        inmueblesServicio.setServicio( serviceMapper.toServicio( propertiesService.getService() ) );

        return inmueblesServicio;
    }

    @Override
    public List<InmueblesServicio> toInmueblesServicios(List<PropertiesService> propertiesServices) {
        if ( propertiesServices == null ) {
            return null;
        }

        List<InmueblesServicio> list = new ArrayList<InmueblesServicio>( propertiesServices.size() );
        for ( PropertiesService propertiesService : propertiesServices ) {
            list.add( toInmueblesServicio( propertiesService ) );
        }

        return list;
    }
}
