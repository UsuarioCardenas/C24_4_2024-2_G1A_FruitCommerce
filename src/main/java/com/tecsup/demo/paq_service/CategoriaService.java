package com.tecsup.demo.paq_service;

import com.tecsup.demo.paq_model.paq_entity.Categoria;
import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    void save(Categoria categoria);
    Optional<Categoria> findById(Integer id);
    List<Categoria> findAll();
    void deleteById(Integer id);
}