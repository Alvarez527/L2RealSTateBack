package com.l2realstate.inmobiliaria.persistence.mapper;

import com.l2realstate.inmobiliaria.domain.PropertiesService;
import com.l2realstate.inmobiliaria.persistence.entity.InmueblesServicio;
import com.l2realstate.inmobiliaria.persistence.entity.InmueblesServicioPK;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-14T13:08:29-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class PropertiesServiceMapperImpl implements PropertiesServiceMapper {

    @Override
    public PropertiesService toPropertiesService(InmueblesServicio inmueblesServicio) {
        if ( inmueblesServicio == null ) {
            return null;
        }

        PropertiesService propertiesService = new PropertiesService();

        Integer idInmueble = inmueblesServicioIdIdInmueble( inmueblesServicio );
        if ( idInmueble != null ) {
            propertiesService.setPropertyId( idInmueble );
        }
        Integer idServicio = inmueblesServicioIdIdServicio( inmueblesServicio );
        if ( idServicio != null ) {
            propertiesService.setServiceId( idServicio );
        }

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

        inmueblesServicio.setId( propertiesServiceToInmueblesServicioPK( propertiesService ) );

        return inmueblesServicio;
    }

    @Override
    public List<InmueblesServicio> toInmuebleServicios(List<PropertiesService> propertiesServices) {
        if ( propertiesServices == null ) {
            return null;
        }

        List<InmueblesServicio> list = new ArrayList<InmueblesServicio>( propertiesServices.size() );
        for ( PropertiesService propertiesService : propertiesServices ) {
            list.add( toInmueblesServicio( propertiesService ) );
        }

        return list;
    }

    private Integer inmueblesServicioIdIdInmueble(InmueblesServicio inmueblesServicio) {
        if ( inmueblesServicio == null ) {
            return null;
        }
        InmueblesServicioPK id = inmueblesServicio.getId();
        if ( id == null ) {
            return null;
        }
        Integer idInmueble = id.getIdInmueble();
        if ( idInmueble == null ) {
            return null;
        }
        return idInmueble;
    }

    private Integer inmueblesServicioIdIdServicio(InmueblesServicio inmueblesServicio) {
        if ( inmueblesServicio == null ) {
            return null;
        }
        InmueblesServicioPK id = inmueblesServicio.getId();
        if ( id == null ) {
            return null;
        }
        Integer idServicio = id.getIdServicio();
        if ( idServicio == null ) {
            return null;
        }
        return idServicio;
    }

    protected InmueblesServicioPK propertiesServiceToInmueblesServicioPK(PropertiesService propertiesService) {
        if ( propertiesService == null ) {
            return null;
        }

        InmueblesServicioPK inmueblesServicioPK = new InmueblesServicioPK();

        inmueblesServicioPK.setIdInmueble( propertiesService.getPropertyId() );
        inmueblesServicioPK.setIdServicio( propertiesService.getServiceId() );

        return inmueblesServicioPK;
    }
}
