package com.l2realstate.inmobiliaria.persistence.mapper;

import com.l2realstate.inmobiliaria.domain.City;
import com.l2realstate.inmobiliaria.persistence.entity.Ciudad;
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
public class CityMapperImpl implements CityMapper {

    @Override
    public City toCity(Ciudad ciudad) {
        if ( ciudad == null ) {
            return null;
        }

        City city = new City();

        if ( ciudad.getIdCiudad() != null ) {
            city.setCityId( ciudad.getIdCiudad() );
        }
        city.setCity( ciudad.getCiudad() );

        return city;
    }

    @Override
    public List<City> toCities(List<Ciudad> ciudades) {
        if ( ciudades == null ) {
            return null;
        }

        List<City> list = new ArrayList<City>( ciudades.size() );
        for ( Ciudad ciudad : ciudades ) {
            list.add( toCity( ciudad ) );
        }

        return list;
    }

    @Override
    public Ciudad toCiudad(City city) {
        if ( city == null ) {
            return null;
        }

        Ciudad ciudad = new Ciudad();

        ciudad.setIdCiudad( city.getCityId() );
        ciudad.setCiudad( city.getCity() );

        return ciudad;
    }

    @Override
    public List<Ciudad> toCiudades(List<City> cities) {
        if ( cities == null ) {
            return null;
        }

        List<Ciudad> list = new ArrayList<Ciudad>( cities.size() );
        for ( City city : cities ) {
            list.add( toCiudad( city ) );
        }

        return list;
    }
}
