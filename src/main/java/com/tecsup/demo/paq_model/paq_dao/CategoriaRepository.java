package com.tecsup.demo.paq_model.paq_dao;

import com.tecsup.demo.paq_model.paq_entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    // Aquí puedes agregar métodos adicionales si los necesitas
}
