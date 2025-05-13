package com.l2realstate.inmobiliaria.persistence.mapper;

import com.l2realstate.inmobiliaria.domain.Customer;
import com.l2realstate.inmobiliaria.domain.Property;
import com.l2realstate.inmobiliaria.persistence.entity.Cliente;
import com.l2realstate.inmobiliaria.persistence.entity.Inmueble;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PropertyTypeMapper.class, CityMapper.class, ResidentialMapper.class, StateMapper.class, OperationMapper.class, PropertiesServiceMapper.class})
public interface PropertyMapper {

    @Mappings({
            @Mapping(source ="idInmueble", target = "propertyId"),
            @Mapping(source ="precio", target = "price"),
            @Mapping(source ="antiguedad", target = "years"),
            @Mapping(source ="area", target = "area"),
            @Mapping(source ="construccion", target = "constructionSize"),
            @Mapping(source ="cuartos", target = "rooms"),
            @Mapping(source ="banos", target = "restrooms"),
            @Mapping(source ="mediobanos", target = "halfRestroom"),
            @Mapping(source ="estacionamientos", target = "parkingLots"),
            @Mapping(source ="descripcion", target = "description"),
            @Mapping(source ="idTipoInmueble", target = "propertyTypeId"),
            @Mapping(source ="idEstado", target = "stateId"),
            @Mapping(source ="idColonia", target = "residentialId"),
            @Mapping(source ="idCiudad", target = "cityId"),
            @Mapping(source ="tipoInmueble", target = "propertyType"),
            @Mapping(source ="ciudad", target = "city"),
            @Mapping(source ="estado", target = "state"),
            @Mapping(source ="colonia", target = "residential"),
            @Mapping(source ="operaciones", target = "operationList"),
            @Mapping(source ="servicios", target = "propertiesServices", ignore = true)
    })
    public Property toProperty(Inmueble inmueble);
    public List<Property> toProperties(List<Inmueble> inmuebles);

    @InheritInverseConfiguration
    public Inmueble toInmueble(Property property);
    public List<Inmueble> toInmuebles(List<Property> properties);

}



