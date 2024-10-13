package com.tecsup.demo.paq_model.paq_entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVenta")
    private Integer idVenta;

    @Column(name = "fecha_venta")
    private String fechaVenta;

    @Column(name = "numero_venta")
    private String numeroVenta;

    @Column(name = "total")
    private double total;

    @ManyToOne
    @JoinColumn(name = "Comprador_idComprador", nullable = false)
    private Comprador comprador;

    @ManyToOne
    @JoinColumn(name = "MetodosPago_idMetodosPago", nullable = false)
    private MetodosPago metodosPago;

    // Constructor vacío
    public Venta() {}

    // Constructor con parámetros
    public Venta(Integer idVenta, String fechaVenta, String numeroVenta, double total, Comprador comprador, MetodosPago metodosPago) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.numeroVenta = numeroVenta;
        this.total = total;
        this.comprador = comprador;
        this.metodosPago = metodosPago;
    }

    // Getter y Setter para idVenta
    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    // Getter y Setter para fechaVenta
    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    // Getter y Setter para numeroVenta
    public String getNumeroVenta() {
        return numeroVenta;
    }

    public void setNumeroVenta(String numeroVenta) {
        this.numeroVenta = numeroVenta;
    }

    // Getter y Setter para total
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    // Getter y Setter para comprador
    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    // Getter y Setter para metodosPago
    public MetodosPago getMetodosPago() {
        return metodosPago;
    }

    public void setMetodosPago(MetodosPago metodosPago) {
        this.metodosPago = metodosPago;
    }

    // Método toString
    @Override
    public String toString() {
        return "Venta{" +
                "idVenta=" + idVenta +
                ", fechaVenta='" + fechaVenta + '\'' +
                ", numeroVenta='" + numeroVenta + '\'' +
                ", total=" + total +
                ", comprador=" + comprador +
                ", metodosPago=" + metodosPago +
                '}';
    }
}