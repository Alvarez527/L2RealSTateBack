package com.l2realstate.inmobiliaria.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tipos_de_inmuebles")
public class TipoInmueble {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tipos_de_inmueble")

    private Integer idTipoInmueble;

    @Column(name="nombre_tipo")
    private String nombreTipo;

    @OneToMany(mappedBy = "tipoInmueble")
    private List<Inmueble> inmuebles;

    public Integer getIdTipoInmueble() {
        return idTipoInmueble;
    }

    public void setIdTipoInmueble(Integer idTipoInmueble) {
        this.idTipoInmueble = idTipoInmueble;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
}
