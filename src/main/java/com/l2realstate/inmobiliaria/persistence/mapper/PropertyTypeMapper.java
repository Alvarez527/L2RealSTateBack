package com.l2realstate.inmobiliaria.persistence.mapper;

import com.l2realstate.inmobiliaria.domain.PropertyType;
import com.l2realstate.inmobiliaria.persistence.entity.TipoInmueble;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PropertyTypeMapper {

    @Mappings({

            @Mapping(source="idTipoInmueble", target="propertyTypeId"),
            @Mapping(source="nombreTipo", target="type"),
    })
    PropertyType toPropertyType(TipoInmueble tipoInmueble);
    List<PropertyType> toPropertyTypes(List<TipoInmueble> tipoInmuebleList);

    @InheritInverseConfiguration

    TipoInmueble toTipoInmueble(PropertyType propertyType);
    List<TipoInmueble> toTipoInmuebles(List<PropertyType> propertyTypes);
}





