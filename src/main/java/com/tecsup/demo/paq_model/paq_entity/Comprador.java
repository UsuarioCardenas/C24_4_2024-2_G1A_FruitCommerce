package com.tecsup.demo.paq_model.paq_entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Comprador")
public class Comprador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idComprador")
    private Integer idComprador;

    @OneToOne
    @JoinColumn(name = "Usuario_idUsuario", nullable = false)
    private Usuario usuario;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "dni")
    private String dni;

    // Constructor vacío
    public Comprador() {}

    // Constructor con parámetros
    public Comprador(Integer idComprador, Usuario usuario, String nombres, String apellidos, String dni) {
        this.idComprador = idComprador;
        this.usuario = usuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    // Getter y Setter para idComprador
    public Integer getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(Integer idComprador) {
        this.idComprador = idComprador;
    }

    // Getter y Setter para usuario
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Getter y Setter para nombres
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    // Getter y Setter para apellidos
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    // Getter y Setter para dni
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    // Método toString
    @Override
    public String toString() {
        return "Comprador{" +
                "idComprador=" + idComprador +
                ", usuario=" + usuario +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
