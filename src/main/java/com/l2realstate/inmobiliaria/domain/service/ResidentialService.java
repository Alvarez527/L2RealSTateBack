package com.l2realstate.inmobiliaria.domain.service;

import com.l2realstate.inmobiliaria.domain.Residential;
import com.l2realstate.inmobiliaria.domain.repository.ResidentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResidentialService {

    @Autowired
    ResidentialRepository residentialRepository;

    public List<Residential> getAll(){

        return residentialRepository.getAll();

    }

    public Optional<Residential> getResidentialById(int residentialId){

        return residentialRepository.getResidentialById(residentialId);
    }

    public Optional<Residential> getResidentialByName(String residential){

       return residentialRepository.getResidentialByName(residential);
    }

    public Residential saveResidential(Residential residential){

        return residentialRepository.saveResidential(residential);
    }

    public boolean deleteResidential(int residentialId){

        if (residentialRepository.getResidentialById(residentialId).isPresent()){

            residentialRepository.deleteResidential(residentialId);
            return true;
        }else{
            return false;
        }
    }

    public ResidentialRepository getResidentialRepository() {
        return residentialRepository;
    }

    public void setResidentialRepository(ResidentialRepository residentialRepository) {
        this.residentialRepository = residentialRepository;
    }
}


