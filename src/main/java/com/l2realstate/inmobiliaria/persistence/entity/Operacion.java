package com.l2realstate.inmobiliaria.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="operaciones")
public class Operacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_operacion")
    private Integer idOperacion;

    @Column(name="id_inmueble")
    private Integer idInmueble;

    @Column(name="tipo_operacion")
    private String tipoOperacion;

    @Column(name="id_cliente")
    private Integer idCliente;

    @Column(name="id_vendedor")
    private Integer idVendedor;


    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_vendedor", insertable = false, updatable = false)
    private Vendedor vendedor;

    @ManyToOne
    @JoinColumn(name = "id_inmueble", insertable = false, updatable = false)
    private Inmueble inmueble;

    @OneToMany(mappedBy = "operacion")
    private List<MensajeCliente> mensajesCliente;

    @OneToMany(mappedBy = "operacion")
    private List<MensajeVendedor> mensajesVendedor;



    public Integer getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public Integer getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public List<MensajeCliente> getMensajesCliente() {
        return mensajesCliente;
    }

    public void setMensajesCliente(List<MensajeCliente> mensajesCliente) {
        this.mensajesCliente = mensajesCliente;
    }

    public List<MensajeVendedor> getMensajesVendedor() {
        return mensajesVendedor;
    }

    public void setMensajesVendedor(List<MensajeVendedor> mensajesVendedor) {
        this.mensajesVendedor = mensajesVendedor;
    }
}
