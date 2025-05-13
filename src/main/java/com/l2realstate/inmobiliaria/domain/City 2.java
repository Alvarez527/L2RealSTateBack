package com.l2realstate.inmobiliaria.domain;

import com.l2realstate.inmobiliaria.persistence.entity.Inmueble;
import jakarta.persistence.*;

import java.util.List;

public class City {

    private int cityId;
    private String city;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}


