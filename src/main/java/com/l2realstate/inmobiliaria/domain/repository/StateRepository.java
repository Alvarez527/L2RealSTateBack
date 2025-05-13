package com.l2realstate.inmobiliaria.domain.repository;

import com.l2realstate.inmobiliaria.domain.State;

import java.util.List;
import java.util.Optional;

public interface StateRepository {

    public List<State> getAll();

    public Optional<State> getStateById(int stateId);

    public Optional<State> getStateByName(String state);

    public State saveState(State state);

    public void deleteState(int stateId);

}


