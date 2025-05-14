package com.l2realstate.inmobiliaria.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="inmuebles")
public class Inmueble {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_inmueble")
    private Integer idInmueble;

    private Double precio;

    private Integer antiguedad;

    private Double area;

    private Double construccion;

    private Integer cuartos;


    private Integer banos;


    private Integer mediobanos;


    private Integer estacionamientos;


    private String descripcion;


    @Column(name="id_tipodeinmueble")

    private Integer idTipoInmueble;

    @Column(name="id_estado")

    private Integer idEstado;

    @Column(name="id_colonia")

    private Integer idColonia;

    @Column(name="id_ciudad")

    private Integer idCiudad;

    @ManyToOne
    @JoinColumn(name = "id_tipodeinmueble", insertable = false, updatable = false)
    private TipoInmueble tipoInmueble;

    @ManyToOne
    @JoinColumn(name = "id_ciudad", insertable = false, updatable = false)
    private Ciudad ciudad;



    @ManyToOne
    @JoinColumn(name = "id_colonia", insertable = false, updatable = false)
    private Colonia colonia;

    @ManyToOne
    @JoinColumn(name = "id_estado", insertable = false, updatable = false)
    private Estado estado;


    @OneToMany(mappedBy = "inmueble")
    private List<Operacion> operaciones;

    @OneToMany(mappedBy = "inmueble")
    private List<InmueblesServicio> servicios;

    public Integer getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Integer antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getConstruccion() {
        return construccion;
    }

    public void setConstruccion(Double construccion) {
        this.construccion = construccion;
    }

    public Integer getCuartos() {
        return cuartos;
    }

    public void setCuartos(Integer cuartos) {
        this.cuartos = cuartos;
    }

    public Integer getBanos() {
        return banos;
    }

    public void setBanos(Integer banos) {
        this.banos = banos;
    }

    public Integer getMediobanos() {
        return mediobanos;
    }

    public void setMediobanos(Integer mediobanos) {
        this.mediobanos = mediobanos;
    }

    public Integer getEstacionamientos() {
        return estacionamientos;
    }

    public void setEstacionamientos(Integer estacionamientos) {
        this.estacionamientos = estacionamientos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdTipoInmueble() {
        return idTipoInmueble;
    }

    public void setIdTipoInmueble(Integer idTipoInmueble) {
        this.idTipoInmueble = idTipoInmueble;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getIdColonia() {
        return idColonia;
    }

    public void setIdColonia(Integer idColonia) {
        this.idColonia = idColonia;
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public TipoInmueble getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(TipoInmueble tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Colonia getColonia() {
        return colonia;
    }

    public void setColonia(Colonia colonia) {
        this.colonia = colonia;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Operacion> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(List<Operacion> operaciones) {
        this.operaciones = operaciones;
    }

    public List<InmueblesServicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<InmueblesServicio> servicios) {
        this.servicios = servicios;
    }
}
