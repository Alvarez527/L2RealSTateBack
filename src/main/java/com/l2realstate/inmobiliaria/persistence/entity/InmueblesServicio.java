package com.l2realstate.inmobiliaria.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name="inmuebles_servicios")
public class InmueblesServicio {

    @EmbeddedId
    private InmueblesServicioPK id;


    @ManyToOne
    @JoinColumn(name = "id_inmueble", insertable = false, updatable = false)
    private Inmueble inmueble;

    @ManyToOne
    @JoinColumn(name = "id_servicio", insertable = false, updatable = false)
    private Servicio servicio;

    public InmueblesServicioPK getId() {
        return id;
    }

    public void setId(InmueblesServicioPK id) {
        this.id = id;
    }



    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
