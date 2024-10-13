package com.tecsup.demo.paq_model.paq_dao;

import com.tecsup.demo.paq_model.paq_entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

    // Encuentra un proveedor por su ID
    Optional<Proveedor> findById(Integer idProveedor);

    // Encuentra un proveedor por su usuario
    Optional<Proveedor> findByUsuarioId(Integer usuarioId);

    // Encuentra todos los proveedores
    List<Proveedor> findAll();

    // Elimina un proveedor por su ID
    void deleteById(Integer id);

    // Aquí puedes agregar más métodos específicos para Proveedor
}