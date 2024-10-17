package com.tecsup.demo.paq_model.paq_entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "contraseña")
    private String contraseña;

    @Column(name = "email")  // Cambiado de 'correo' a 'email'
    private String email;  // Cambiado de 'correo' a 'email'

    @Column(name = "RUC")
    private String RUC;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole role;  // Rol del usuario: PROVEEDOR o COMPRADOR

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Proveedor proveedor;

    // Relación uno a uno con Comprador
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Comprador comprador;

    @Column(name = "source")
    @Enumerated(EnumType.STRING)
    private RegistrationSource source;

    // Constructor vacío
    public Usuario() {}

    // Constructor con parámetros
    public Usuario(Integer id, String usuario, String contraseña, String email, String RUC, String direccion, String telefono, UserRole role, Proveedor proveedor, Comprador comprador, RegistrationSource source) {
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.email = email;  // Cambiado de 'correo' a 'email'
        this.RUC = RUC;
        this.direccion = direccion;
        this.telefono = telefono;
        this.role = role;
        this.proveedor = proveedor;
        this.comprador = comprador;
        this.source = source;
    }

    // Getter y Setter para idUsuario
    public Integer getIdUsuario() {
        return id;
    }

    public void setIdUsuario(Integer id) {
        this.id = id;
    }

    // Getter y Setter para usuario
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    // Getter y Setter para contraseña
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    // Getter y Setter para email
    public String getEmail() {  // Cambiado de 'correo' a 'email'
        return email;  // Cambiado de 'correo' a 'email'
    }

    public void setEmail(String email) {  // Cambiado de 'correo' a 'email'
        this.email = email;  // Cambiado de 'correo' a 'email'
    }

    // Getter y Setter para RUC
    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    // Getter y Setter para direccion
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Getter y Setter para telefono
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Getter y Setter para role
    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    // Getter y Setter para proveedor
    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    // Getter y Setter para comprador
    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    // Getter y Setter para source
    public RegistrationSource getSource() {
        return source;
    }

    public void setSource(RegistrationSource source) {
        this.source = source;
    }

    // Método toString
    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + id +
                ", usuario='" + usuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", email='" + email + '\'' +  // Cambiado de 'correo' a 'email'
                ", RUC='" + RUC + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", role=" + role +
                ", proveedor=" + proveedor +
                ", comprador=" + comprador +
                ", source=" + source +
                '}';
    }
}