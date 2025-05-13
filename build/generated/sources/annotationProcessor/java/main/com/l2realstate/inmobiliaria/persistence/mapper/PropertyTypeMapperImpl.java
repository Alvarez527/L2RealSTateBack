package com.l2realstate.inmobiliaria.persistence.mapper;

import com.l2realstate.inmobiliaria.domain.PropertyType;
import com.l2realstate.inmobiliaria.persistence.entity.TipoInmueble;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-31T20:43:55-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class PropertyTypeMapperImpl implements PropertyTypeMapper {

    @Override
    public PropertyType toPropertyType(TipoInmueble tipoInmueble) {
        if ( tipoInmueble == null ) {
            return null;
        }

        PropertyType propertyType = new PropertyType();

        if ( tipoInmueble.getIdTipoInmueble() != null ) {
            propertyType.setPropertyTypeId( tipoInmueble.getIdTipoInmueble() );
        }
        propertyType.setType( tipoInmueble.getNombreTipo() );

        return propertyType;
    }

    @Override
    public List<PropertyType> toPropertyTypes(List<TipoInmueble> tipoInmuebleList) {
        if ( tipoInmuebleList == null ) {
            return null;
        }

        List<PropertyType> list = new ArrayList<PropertyType>( tipoInmuebleList.size() );
        for ( TipoInmueble tipoInmueble : tipoInmuebleList ) {
            list.add( toPropertyType( tipoInmueble ) );
        }

        return list;
    }

    @Override
    public TipoInmueble toTipoInmueble(PropertyType propertyType) {
        if ( propertyType == null ) {
            return null;
        }

        TipoInmueble tipoInmueble = new TipoInmueble();

        tipoInmueble.setIdTipoInmueble( propertyType.getPropertyTypeId() );
        tipoInmueble.setNombreTipo( propertyType.getType() );

        return tipoInmueble;
    }

    @Override
    public List<TipoInmueble> toTipoInmuebles(List<PropertyType> propertyTypes) {
        if ( propertyTypes == null ) {
            return null;
        }

        List<TipoInmueble> list = new ArrayList<TipoInmueble>( propertyTypes.size() );
        for ( PropertyType propertyType : propertyTypes ) {
            list.add( toTipoInmueble( propertyType ) );
        }

        return list;
    }
}
