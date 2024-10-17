package com.tecsup.demo.paq_model.paq_entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private Integer idProducto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private double precio;

    @ManyToOne
    @JoinColumn(name = "Proveedor_idProveedor", nullable = false)
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "Categoria_idCategoria", nullable = false)
    private Categoria categoria;

    // Constructor vacío
    public Producto() {}

    // Constructor con parámetros
    public Producto(Integer idProducto, String nombre, double precio, Proveedor proveedor, Categoria categoria) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.proveedor = proveedor;
        this.categoria = categoria;
    }

    // Getter y Setter para idProducto
    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    // Getter y Setter para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para precio
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Getter y Setter para proveedor
    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    // Getter y Setter para categoria
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // Método toString
    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", proveedor=" + proveedor +
                ", categoria=" + categoria +
                '}';
    }
}