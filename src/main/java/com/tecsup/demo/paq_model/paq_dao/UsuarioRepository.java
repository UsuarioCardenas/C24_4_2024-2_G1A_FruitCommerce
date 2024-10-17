package com.tecsup.demo.paq_model.paq_dao;

import com.tecsup.demo.paq_model.paq_entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findById(Integer id);
}
