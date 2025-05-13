package com.l2realstate.inmobiliaria.domain.repository;

import com.l2realstate.inmobiliaria.domain.Residential;

import java.util.List;
import java.util.Optional;

public interface ResidentialRepository {

    public List<Residential> getAll();

    public Optional<Residential> getResidentialById(int residentialId);

    public Optional<Residential> getResidentialByName(String residential);

    public Residential saveResidential(Residential residential);

    public void deleteResidential(int residentialId);


}


