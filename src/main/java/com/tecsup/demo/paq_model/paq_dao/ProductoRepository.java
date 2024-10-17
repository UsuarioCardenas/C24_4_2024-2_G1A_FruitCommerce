package com.tecsup.demo.paq_model.paq_dao;

import com.tecsup.demo.paq_model.paq_entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    // Método para encontrar productos por nombre
    List<Producto> findByNombre(String nombre);

    // Método para encontrar productos por ID de categoría
    List<Producto> findByCategoriaId(Integer categoriaId);

    // Método para encontrar productos por ID de proveedor
    List<Producto> findByProveedorId(Integer proveedorId);
}