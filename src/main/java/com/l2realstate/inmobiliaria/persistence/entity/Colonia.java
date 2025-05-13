package com.l2realstate.inmobiliaria.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name="colonias")
public class Colonia {

    @Id
    //sirve para indicarle que se autoincremente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_colonia")
    private Integer idColonia;

    private String colonia;

    @OneToMany(mappedBy = "colonia")
    private List<Inmueble> inmuebles;

    public Integer getIdColonia() {
        return idColonia;
    }

    public void setIdColonia(Integer idColonia) {
        this.idColonia = idColonia;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
}
