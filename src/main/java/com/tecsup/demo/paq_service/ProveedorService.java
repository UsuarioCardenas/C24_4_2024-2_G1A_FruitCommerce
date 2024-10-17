package com.tecsup.demo.paq_service;

import com.tecsup.demo.paq_model.paq_entity.Proveedor;

import java.util.List;
import java.util.Optional;

public interface ProveedorService {
    Optional<Proveedor> findById(Integer id);
    List<Proveedor> findAll();
    void save(Proveedor proveedor);
    void deleteById(Integer id);
    Optional<Proveedor> findByUsuarioId(Integer usuarioId);
}
