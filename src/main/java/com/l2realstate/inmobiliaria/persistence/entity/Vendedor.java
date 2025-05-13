package com.l2realstate.inmobiliaria.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="vendedores")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_vendedor")
    private Integer idVendedor;

    @Column(name="nombre_vendedor")
    private String nombreVendedor;

    @Column(name="telefono_vendedor")
    private String telefonoVendedor;

    @Column(name="email_vendedor")
    private String emailVendedor;

    @OneToMany(mappedBy = "vendedor")
    private List<Operacion> operaciones;

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getTelefonoVendedor() {
        return telefonoVendedor;
    }

    public void setTelefonoVendedor(String telefonoVendedor) {
        this.telefonoVendedor = telefonoVendedor;
    }

    public String getEmailVendedor() {
        return emailVendedor;
    }

    public void setEmailVendedor(String emailVendedor) {
        this.emailVendedor = emailVendedor;
    }
}
