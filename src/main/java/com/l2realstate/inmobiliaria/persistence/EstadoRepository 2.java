package com.l2realstate.inmobiliaria.persistence;

import com.l2realstate.inmobiliaria.domain.State;
import com.l2realstate.inmobiliaria.domain.repository.StateRepository;
import com.l2realstate.inmobiliaria.persistence.crud.EstadoCrudRepository;
import com.l2realstate.inmobiliaria.persistence.entity.Estado;
import com.l2realstate.inmobiliaria.persistence.mapper.StateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EstadoRepository implements StateRepository {

    @Autowired
    EstadoCrudRepository estadoCrudRepository;

    @Autowired
    StateMapper stateMapper;


    @Override
    public List<State> getAll() {

        List<Estado> estados = (List<Estado>) estadoCrudRepository.findAll();

        return stateMapper.toStates(estados);
    }

    @Override
    public Optional<State> getStateById(int stateId) {

        return estadoCrudRepository.findById(stateId).map(a -> stateMapper.toState(a));
    }

    @Override
    public Optional<State> getStateByName(String state) {

        return estadoCrudRepository.findByEstado(state).map(a -> stateMapper.toState(a));
    }

    @Override
    public State saveState(State state) {

        Estado estado = stateMapper.toEstado(state);
        estadoCrudRepository.save(estado);
        return state;
    }

    @Override
    public void deleteState(int stateId) {

        estadoCrudRepository.deleteById(stateId);

    }
}
