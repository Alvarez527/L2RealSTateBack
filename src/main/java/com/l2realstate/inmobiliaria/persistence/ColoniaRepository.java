package com.l2realstate.inmobiliaria.persistence;

import com.l2realstate.inmobiliaria.domain.Residential;
import com.l2realstate.inmobiliaria.domain.repository.ResidentialRepository;
import com.l2realstate.inmobiliaria.persistence.crud.ColoniaCrudRepository;
import com.l2realstate.inmobiliaria.persistence.entity.Colonia;
import com.l2realstate.inmobiliaria.persistence.mapper.ResidentialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ColoniaRepository implements ResidentialRepository {

    @Autowired
    ColoniaCrudRepository coloniaCrudRepository;

    @Autowired
    ResidentialMapper residentialMapper;
    @Override
    public List<Residential> getAll() {
        List<Colonia> colonias = (List<Colonia>) coloniaCrudRepository.findAll();
        return residentialMapper.toResidentials(colonias);

    }

    @Override
    public Optional<Residential> getResidentialById(int residentialId) {
        return coloniaCrudRepository.findById(residentialId).map(a -> residentialMapper.toResidential(a));
    }

    @Override
    public Optional<Residential> getResidentialByName(String residential) {

        return coloniaCrudRepository.findColoniaByColonia(residential).map(a -> residentialMapper.toResidential(a));
    }

    @Override
    public Residential saveResidential(Residential residential) {
        Colonia colonia = residentialMapper.toColonia(residential);
        coloniaCrudRepository.save(colonia);
        return residential;
    }

    @Override
    public void deleteResidential(int residentialId) {

        coloniaCrudRepository.deleteById(residentialId);

    }
}
