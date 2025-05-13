package com.l2realstate.inmobiliaria.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
//la anotación de tabla es porque el nombre es diferente al de la clase
@Table(name = "ciudades")
public class Ciudad {

    //anotacion para indicar que es el id de la tabla
    @Id
    //sirve para indicarle que se autoincremente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //esta anotación se indica porque el nombre es diferente al de la base de datos
    @Column(name = "id_ciudad")
    private Integer idCiudad;

    //como el nombre no cambia no se pone ninguna anotación
    private String ciudad;

    @OneToMany(mappedBy = "ciudad")
    private List<Inmueble> inmuebles;

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
