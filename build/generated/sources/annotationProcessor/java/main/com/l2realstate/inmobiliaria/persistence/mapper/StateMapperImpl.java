package com.l2realstate.inmobiliaria.persistence.mapper;

import com.l2realstate.inmobiliaria.domain.State;
import com.l2realstate.inmobiliaria.persistence.entity.Estado;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-31T20:43:56-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class StateMapperImpl implements StateMapper {

    @Override
    public State toState(Estado estado) {
        if ( estado == null ) {
            return null;
        }

        State state = new State();

        if ( estado.getIdEstado() != null ) {
            state.setStateId( estado.getIdEstado() );
        }
        state.setState( estado.getEstado() );

        return state;
    }

    @Override
    public List<State> toStates(List<Estado> estados) {
        if ( estados == null ) {
            return null;
        }

        List<State> list = new ArrayList<State>( estados.size() );
        for ( Estado estado : estados ) {
            list.add( toState( estado ) );
        }

        return list;
    }

    @Override
    public Estado toEstado(State state) {
        if ( state == null ) {
            return null;
        }

        Estado estado = new Estado();

        estado.setIdEstado( state.getStateId() );
        estado.setEstado( state.getState() );

        return estado;
    }

    @Override
    public List<Estado> toEstados(List<State> states) {
        if ( states == null ) {
            return null;
        }

        List<Estado> list = new ArrayList<Estado>( states.size() );
        for ( State state : states ) {
            list.add( toEstado( state ) );
        }

        return list;
    }
}
