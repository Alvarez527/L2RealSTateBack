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

    // Constructor vacío
    public InmueblesServicioPK() {}

    // Constructor con todos los campos
    public InmueblesServicioPK(Integer idInmueble, Integer idServicio) {
        this.idInmueble = idInmueble;
        this.idServicio = idServicio;
    }

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
