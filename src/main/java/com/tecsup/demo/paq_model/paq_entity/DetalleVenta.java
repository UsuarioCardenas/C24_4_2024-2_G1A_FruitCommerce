package com.tecsup.demo.paq_model.paq_entity;

import jakarta.persistence.*;

@Entity
@Table(name = "DetalleVenta")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetalleVenta")
    private Integer idDetalleVenta;

    @Column(name = "cantidad")
    private String cantidad;

    @Column(name = "precio_unitario")
    private double precioUnitario;

    @Column(name = "subtotal")
    private double subtotal;

    @ManyToOne
    @JoinColumn(name = "Venta_idVenta", nullable = false)
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "Producto_idProducto", nullable = false)
    private Producto producto;

    // Constructor vacío
    public DetalleVenta() {}

    // Constructor con parámetros
    public DetalleVenta(Integer idDetalleVenta, String cantidad, double precioUnitario, double subtotal, Venta venta, Producto producto) {
        this.idDetalleVenta = idDetalleVenta;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
        this.venta = venta;
        this.producto = producto;
    }

    // Getter y Setter para idDetalleVenta
    public Integer getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(Integer idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    // Getter y Setter para cantidad
    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    // Getter y Setter para precioUnitario
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    // Getter y Setter para subtotal
    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    // Getter y Setter para venta
    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    // Getter y Setter para producto
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    // Método toString
    @Override
    public String toString() {
        return "DetalleVenta{" +
                "idDetalleVenta=" + idDetalleVenta +
                ", cantidad='" + cantidad + '\'' +
                ", precioUnitario=" + precioUnitario +
                ", subtotal=" + subtotal +
                ", venta=" + venta +
                ", producto=" + producto +
                '}';
    }
}
