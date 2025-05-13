package com.l2realstate.inmobiliaria.domain.repository;

import com.l2realstate.inmobiliaria.domain.City;

import java.util.List;
import java.util.Optional;

public interface CityRepository {

    public List<City> getAll();

    public Optional<City> getCity(int cityId);

    public City saveCity(City city);

    public void deleteCity(int cityId);

}


