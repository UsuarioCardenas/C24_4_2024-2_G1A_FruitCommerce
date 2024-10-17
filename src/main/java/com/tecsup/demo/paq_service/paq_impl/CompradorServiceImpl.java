package com.tecsup.demo.paq_service.paq_impl;

import com.tecsup.demo.paq_model.paq_dao.CompradorRepository;
import com.tecsup.demo.paq_model.paq_entity.Comprador;
import com.tecsup.demo.paq_service.CompradorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompradorServiceImpl implements CompradorService {

    private final CompradorRepository compradorRepository;

    // Constructor que acepta CompradorRepository
    public CompradorServiceImpl(CompradorRepository compradorRepository) {
        this.compradorRepository = compradorRepository;
    }

    @Override
    public Optional<Comprador> findById(Integer id) {
        return compradorRepository.findById(id);
    }

    @Override
    public List<Comprador> findAll() {
        return compradorRepository.findAll();
    }

    @Override
    public void save(Comprador comprador) {
        compradorRepository.save(comprador);
    }

    @Override
    public void deleteById(Integer id) {
        compradorRepository.deleteById(id);
    }

    // Método para buscar un comprador por su usuario
    @Override
    public Optional<Comprador> findByUsuarioId(Integer usuarioId) {
        return compradorRepository.findByUsuarioId(usuarioId);
    }
}
