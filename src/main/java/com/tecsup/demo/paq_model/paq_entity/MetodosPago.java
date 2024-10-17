package com.tecsup.demo.paq_model.paq_entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MetodosPago")
public class MetodosPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMetodosPago")
    private Integer idMetodosPago;

    @Column(name = "metodo")
    private String metodo;

    // Constructor vacío
    public MetodosPago() {}

    // Constructor con parámetros
    public MetodosPago(Integer idMetodosPago, String metodo) {
        this.idMetodosPago = idMetodosPago;
        this.metodo = metodo;
    }

    // Getter y Setter para idMetodosPago
    public Integer getIdMetodosPago() {
        return idMetodosPago;
    }

    public void setIdMetodosPago(Integer idMetodosPago) {
        this.idMetodosPago = idMetodosPago;
    }

    // Getter y Setter para metodo
    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    // Método toString
    @Override
    public String toString() {
        return "MetodosPago{" +
                "idMetodosPago=" + idMetodosPago +
                ", metodo='" + metodo + '\'' +
                '}';
    }
}