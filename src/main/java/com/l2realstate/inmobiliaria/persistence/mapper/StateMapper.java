package com.l2realstate.inmobiliaria.persistence.mapper;

import com.l2realstate.inmobiliaria.domain.State;
import com.l2realstate.inmobiliaria.persistence.entity.Estado;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StateMapper {

    @Mappings({

            @Mapping(source = "idEstado", target="stateId"),
            @Mapping(source = "estado", target="state")

    })
    State toState(Estado estado);
    List<State> toStates(List<Estado> estados);


    @InheritInverseConfiguration
    Estado toEstado(State state);
    List<Estado> toEstados(List<State> states);
}



