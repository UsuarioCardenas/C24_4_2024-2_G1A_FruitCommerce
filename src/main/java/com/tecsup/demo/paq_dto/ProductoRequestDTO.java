package com.tecsup.demo.paq_dto;

public class ProductoRequestDTO {
    private String nombre;
    private double precio;
    private Integer categoriaId; // ID de la categoría seleccionada
    private Integer proveedorId;  // ID del proveedor

    // Constructor vacío
    public ProductoRequestDTO() {
    }

    // Constructor con parámetros
    public ProductoRequestDTO(String nombre, double precio, Integer categoriaId, Integer proveedorId) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoriaId = categoriaId;
        this.proveedorId = proveedorId;
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Integer getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Integer proveedorId) {
        this.proveedorId = proveedorId;
    }
}