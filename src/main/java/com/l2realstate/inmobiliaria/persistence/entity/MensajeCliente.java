package com.l2realstate.inmobiliaria.persistence.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="mensajes_cliente")
public class MensajeCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_mensaje_cliente")
    private Integer idMensajeCliente;

    @Column(name="id_operacion")
    private Integer idOperacion;

    @Column(name="fecha_mcliente")
    private LocalDateTime fechaMCliente;

    @Column(name="mensaje_cliente")
    private String mensaje;


    @ManyToOne
    @JoinColumn(name = "id_operacion", insertable = false, updatable = false)
    private Operacion operacion;


    public Operacion getOperacion() {
        return operacion;
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }

    public Integer getIdMensajeCliente() {
        return idMensajeCliente;
    }

    public void setIdMensajeCliente(Integer idMensajeCliente) {
        this.idMensajeCliente = idMensajeCliente;
    }

    public Integer getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public LocalDateTime getFechaMCliente() {
        return fechaMCliente;
    }

    public void setFechaMCliente(LocalDateTime fechaMCliente) {
        this.fechaMCliente = fechaMCliente;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}

