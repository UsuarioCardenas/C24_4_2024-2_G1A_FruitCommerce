package com.tecsup.demo.paq_model.paq_entity;
import jakarta.persistence.*;

@Entity
@Table(name = "carrito")
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCarrito")
    private Integer idCarrito;

    @Column(name = "fecha_creacion")
    private String fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "Comprador_idComprador", nullable = false)
    private Comprador comprador;

    // Constructor vacío
    public Carrito() {}

    // Constructor con parámetros
    public Carrito(Integer idCarrito, String fechaCreacion, Comprador comprador) {
        this.idCarrito = idCarrito;
        this.fechaCreacion = fechaCreacion;
        this.comprador = comprador;
    }

    // Getter y Setter para idCarrito
    public Integer getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(Integer idCarrito) {
        this.idCarrito = idCarrito;
    }

    // Getter y Setter para fechaCreacion
    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    // Getter y Setter para comprador
    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    // Método toString
    @Override
    public String toString() {
        return "Carrito{" +
                "idCarrito=" + idCarrito +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", comprador=" + comprador +
                '}';
    }
}