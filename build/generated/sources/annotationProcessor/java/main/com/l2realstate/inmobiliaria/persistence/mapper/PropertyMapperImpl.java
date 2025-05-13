package com.l2realstate.inmobiliaria.persistence.mapper;

import com.l2realstate.inmobiliaria.domain.Property;
import com.l2realstate.inmobiliaria.persistence.entity.Inmueble;
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
public class PropertyMapperImpl implements PropertyMapper {

    @Autowired
    private PropertyTypeMapper propertyTypeMapper;
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private ResidentialMapper residentialMapper;
    @Autowired
    private StateMapper stateMapper;
    @Autowired
    private OperationMapper operationMapper;

    @Override
    public Property toProperty(Inmueble inmueble) {
        if ( inmueble == null ) {
            return null;
        }

        Property property = new Property();

        if ( inmueble.getIdInmueble() != null ) {
            property.setPropertyId( inmueble.getIdInmueble() );
        }
        property.setPrice( inmueble.getPrecio() );
        if ( inmueble.getAntiguedad() != null ) {
            property.setYears( inmueble.getAntiguedad() );
        }
        property.setArea( inmueble.getArea() );
        property.setConstructionSize( inmueble.getConstruccion() );
        if ( inmueble.getCuartos() != null ) {
            property.setRooms( inmueble.getCuartos() );
        }
        if ( inmueble.getBanos() != null ) {
            property.setRestrooms( inmueble.getBanos() );
        }
        if ( inmueble.getMediobanos() != null ) {
            property.setHalfRestroom( inmueble.getMediobanos() );
        }
        if ( inmueble.getEstacionamientos() != null ) {
            property.setParkingLots( inmueble.getEstacionamientos() );
        }
        property.setDescription( inmueble.getDescripcion() );
        if ( inmueble.getIdTipoInmueble() != null ) {
            property.setPropertyTypeId( inmueble.getIdTipoInmueble() );
        }
        if ( inmueble.getIdEstado() != null ) {
            property.setStateId( inmueble.getIdEstado() );
        }
        if ( inmueble.getIdColonia() != null ) {
            property.setResidentialId( inmueble.getIdColonia() );
        }
        if ( inmueble.getIdCiudad() != null ) {
            property.setCityId( inmueble.getIdCiudad() );
        }
        property.setPropertyType( propertyTypeMapper.toPropertyType( inmueble.getTipoInmueble() ) );
        property.setCity( cityMapper.toCity( inmueble.getCiudad() ) );
        property.setState( stateMapper.toState( inmueble.getEstado() ) );
        property.setResidential( residentialMapper.toResidential( inmueble.getColonia() ) );
        property.setOperationList( operationMapper.toOperations( inmueble.getOperaciones() ) );

        return property;
    }

    @Override
    public List<Property> toProperties(List<Inmueble> inmuebles) {
        if ( inmuebles == null ) {
            return null;
        }

        List<Property> list = new ArrayList<Property>( inmuebles.size() );
        for ( Inmueble inmueble : inmuebles ) {
            list.add( toProperty( inmueble ) );
        }

        return list;
    }

    @Override
    public Inmueble toInmueble(Property property) {
        if ( property == null ) {
            return null;
        }

        Inmueble inmueble = new Inmueble();

        inmueble.setIdInmueble( property.getPropertyId() );
        inmueble.setPrecio( property.getPrice() );
        inmueble.setAntiguedad( property.getYears() );
        inmueble.setArea( property.getArea() );
        inmueble.setConstruccion( property.getConstructionSize() );
        inmueble.setCuartos( property.getRooms() );
        inmueble.setBanos( property.getRestrooms() );
        inmueble.setMediobanos( property.getHalfRestroom() );
        inmueble.setEstacionamientos( property.getParkingLots() );
        inmueble.setDescripcion( property.getDescription() );
        inmueble.setIdTipoInmueble( property.getPropertyTypeId() );
        inmueble.setIdEstado( property.getStateId() );
        inmueble.setIdColonia( property.getResidentialId() );
        inmueble.setIdCiudad( property.getCityId() );
        inmueble.setTipoInmueble( propertyTypeMapper.toTipoInmueble( property.getPropertyType() ) );
        inmueble.setCiudad( cityMapper.toCiudad( property.getCity() ) );
        inmueble.setEstado( stateMapper.toEstado( property.getState() ) );
        inmueble.setColonia( residentialMapper.toColonia( property.getResidential() ) );
        inmueble.setOperaciones( operationMapper.toOperaciones( property.getOperationList() ) );

        return inmueble;
    }

    @Override
    public List<Inmueble> toInmuebles(List<Property> properties) {
        if ( properties == null ) {
            return null;
        }

        List<Inmueble> list = new ArrayList<Inmueble>( properties.size() );
        for ( Property property : properties ) {
            list.add( toInmueble( property ) );
        }

        return list;
    }
}
