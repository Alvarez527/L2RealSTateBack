package com.l2realstate.inmobiliaria.persistence.mapper;

import com.l2realstate.inmobiliaria.domain.City;
import com.l2realstate.inmobiliaria.persistence.entity.Ciudad;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {

    @Mappings({

            @Mapping(source = "idCiudad", target = "cityId"),
            @Mapping(source = "ciudad", target = "city"),

    })
    City toCity(Ciudad ciudad);
    List<City> toCities(List<Ciudad> ciudades);

    @InheritInverseConfiguration
    Ciudad toCiudad(City city);
    List<Ciudad> toCiudades(List<City> cities);

}


