package com.l2realstate.inmobiliaria.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_servicio")
    private Integer idServicio;

    private String servicio;

    @OneToMany(mappedBy = "servicio")
    private List<InmueblesServicio> inmueblesServicios;

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public List<InmueblesServicio> getInmueblesServicios() {
        return inmueblesServicios;
    }

    public void setInmueblesServicios(List<InmueblesServicio> inmueblesServicios) {
        this.inmueblesServicios = inmueblesServicios;
    }
}
