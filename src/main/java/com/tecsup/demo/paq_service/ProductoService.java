package com.tecsup.demo.paq_service;
import com.tecsup.demo.paq_model.paq_entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    // Crear un nuevo producto
    void save(Producto producto);

    // Leer un producto por su ID
    Optional<Producto> findById(Integer id);

    // Leer todos los productos
    List<Producto> findAll();

    // Actualizar un producto existente
    void update(Integer id, Producto producto);

    // Eliminar un producto por su ID
    void deleteById(Integer id);

    // Puedes agregar más métodos según tus necesidades, por ejemplo:
    // Buscar productos por nombre, categoría, proveedor, etc.
    List<Producto> findByNombre(String nombre);
    List<Producto> findByCategoriaId(Integer categoriaId);
    List<Producto> findByProveedorId(Integer proveedorId);


}