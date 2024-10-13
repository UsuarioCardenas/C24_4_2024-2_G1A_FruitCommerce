package com.tecsup.demo.paq_service;

import com.tecsup.demo.paq_model.paq_entity.Comprador;

import java.util.List;
import java.util.Optional;

public interface CompradorService {
    Optional<Comprador> findById(Integer id);
    List<Comprador> findAll();
    void save(Comprador comprador);
    void deleteById(Integer id);
    Optional<Comprador> findByUsuarioId(Integer usuarioId);
}

