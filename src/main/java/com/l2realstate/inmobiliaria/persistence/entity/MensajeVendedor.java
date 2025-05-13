package com.l2realstate.inmobiliaria.persistence.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="mensajes_vendedor")
public class MensajeVendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_mensaje_vendedor")
    private Integer idMensajeVendedor;

    @Column(name="id_operacion")
    private Integer idOperacion;

    @Column(name="fecha_mvendedor")
    private LocalDateTime fechaMVendedor;

    @Column(name="mensaje_vendedor")
    private String mensajeVendedor;



    @ManyToOne
    @JoinColumn(name = "id_operacion", insertable = false, updatable = false)
    private Operacion operacion;

    public Integer getIdMensajeVendedor() {
        return idMensajeVendedor;
    }

    public void setIdMensajeVendedor(Integer idMensajeVendedor) {
        this.idMensajeVendedor = idMensajeVendedor;
    }

    public Integer getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public LocalDateTime getFechaMVendedor() {
        return fechaMVendedor;
    }

    public void setFechaMVendedor(LocalDateTime fechaMVendedor) {
        this.fechaMVendedor = fechaMVendedor;
    }

    public String getMensajeVendedor() {
        return mensajeVendedor;
    }

    public void setMensajeVendedor(String mensajeVendedor) {
        this.mensajeVendedor = mensajeVendedor;
    }
}
