package com.tecsup.demo.paq_model.paq_dao;

import com.tecsup.demo.paq_model.paq_entity.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompradorRepository extends JpaRepository<Comprador, Integer> {

    // Encuentra un comprador por su ID
    Optional<Comprador> findById(Integer id);

    // Encuentra un comprador por su usuario
    Optional<Comprador> findByUsuarioId(Integer usuarioId);

    // Encuentra todos los compradores
    List<Comprador> findAll();

    // Elimina un comprador por su ID
    void deleteById(Integer id);

    // Aquí puedes agregar más métodos específicos para Comprador
}