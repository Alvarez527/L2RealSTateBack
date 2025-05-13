package com.l2realstate.inmobiliaria.persistence;

import com.l2realstate.inmobiliaria.domain.City;
import com.l2realstate.inmobiliaria.domain.repository.CityRepository;
import com.l2realstate.inmobiliaria.persistence.crud.CiudadCrudRepository;
import com.l2realstate.inmobiliaria.persistence.entity.Ciudad;
import com.l2realstate.inmobiliaria.persistence.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CiudadRepository implements CityRepository {

    @Autowired
    CiudadCrudRepository ciudadCrudRepository;

    @Autowired
    CityMapper cityMapper;
    @Override
    public List<City> getAll() {

        List<Ciudad> ciudades = (List<Ciudad>) ciudadCrudRepository.findAll();
        return cityMapper.toCities(ciudades);
    }

    @Override
    public Optional<City> getCity(int cityId) {

        return ciudadCrudRepository.findById(cityId).map(a -> cityMapper.toCity(a));

    }

    @Override
    public City saveCity(City city) {

        Ciudad ciudad = cityMapper.toCiudad(city);
        ciudadCrudRepository.save(ciudad);
        return city;
    }

    @Override
    public void deleteCity(int cityId) {

        ciudadCrudRepository.deleteById(cityId);

    }
}
