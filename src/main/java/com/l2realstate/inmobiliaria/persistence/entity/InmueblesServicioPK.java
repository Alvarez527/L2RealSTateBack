package com.l2realstate.inmobiliaria.persistence.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class InmueblesServicioPK implements Serializable {

    @Column(name="id_inmueble")
    private Integer idInmueble;

    @Column(name="id_servicio")
    private Integer idServicio;

    public Integer getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }
}
