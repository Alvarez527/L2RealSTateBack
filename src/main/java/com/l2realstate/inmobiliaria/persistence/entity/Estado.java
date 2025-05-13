package com.l2realstate.inmobiliaria.persistence.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="estados")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_estado")
    private Integer idEstado;

    private String estado;

    @OneToMany(mappedBy = "estado")
    private List<Inmueble> inmuebles;

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
