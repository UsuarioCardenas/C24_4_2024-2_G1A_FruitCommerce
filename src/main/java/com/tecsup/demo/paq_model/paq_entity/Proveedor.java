package com.tecsup.demo.paq_model.paq_entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProveedor")
    private Integer idProveedor;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "nombre_empresa")
    private String nombreEmpresa;

    // Constructor vacío
    public Proveedor() {}

    // Constructor con parámetros
    public Proveedor(Integer idProveedor, Usuario usuario, String nombreEmpresa) {
        this.idProveedor = idProveedor;
        this.usuario = usuario;
        this.nombreEmpresa = nombreEmpresa;
    }

    // Getter y Setter para idProveedor
    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    // Getter y Setter para usuario
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Getter y Setter para nombreEmpresa
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    // Método toString
    @Override
    public String toString() {
        return "Proveedor{" +
                "idProveedor=" + idProveedor +
                ", usuario=" + usuario +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                '}';
    }
}