package com.l2realstate.inmobiliaria.domain.service;

import com.l2realstate.inmobiliaria.domain.State;
import com.l2realstate.inmobiliaria.domain.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    @Autowired
    StateRepository stateRepository;

    public List<State> getAll(){

        return (List<State>) stateRepository.getAll();
    }

    public Optional<State> getStateById(int stateId){

        return stateRepository.getStateById(stateId);
    }
    public Optional<State> getStateByName(String state){

        return stateRepository.getStateByName(state);
    }

    public State saveState(State state){

        return stateRepository.saveState(state);

    }

    public Boolean deleteState(int stateId){

        if (stateRepository.getStateById(stateId).isPresent()) {

            stateRepository.deleteState(stateId);
            return true;
        }else {
            return false;
        }

    }



}

