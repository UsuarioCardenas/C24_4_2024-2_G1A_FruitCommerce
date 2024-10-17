package com.tecsup.demo.paq_service;

import com.tecsup.demo.paq_model.paq_entity.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> findByEmail(String Correo);
    void save(Usuario usuario);
    Optional<Usuario> findById(Integer id);
}
