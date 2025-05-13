package com.l2realstate.inmobiliaria.domain.service;

import com.l2realstate.inmobiliaria.domain.City;
import com.l2realstate.inmobiliaria.domain.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City>  getAll(){

        return cityRepository.getAll();
    }

    public Optional<City> getCity(int cityId){

        return cityRepository.getCity(cityId);
    }

    public City saveCity(City city){

        return cityRepository.saveCity(city);
    }

    public boolean deleteCity(int cityId){

        if(cityRepository.getCity(cityId).isPresent()){

            cityRepository.deleteCity(cityId);
            return true;
        }else{

            return false;
        }

    }




}


