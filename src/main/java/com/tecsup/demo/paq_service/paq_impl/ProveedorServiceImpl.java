package com.tecsup.demo.paq_service.paq_impl;

import com.tecsup.demo.paq_model.paq_dao.ProveedorRepository;
import com.tecsup.demo.paq_model.paq_entity.Proveedor;
import com.tecsup.demo.paq_service.ProveedorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepository proveedorRepository;

    // Constructor que acepta ProveedorRepository
    public ProveedorServiceImpl(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public Optional<Proveedor> findById(Integer id) {
        return proveedorRepository.findById(id);
    }

    @Override
    public List<Proveedor> findAll() {
        return proveedorRepository.findAll();
    }

    @Override
    public void save(Proveedor proveedor) {
        proveedorRepository.save(proveedor);
    }

    @Override
    public void deleteById(Integer id) {
        proveedorRepository.deleteById(id);
    }

    @Override
    public Optional<Proveedor> findByUsuarioId(Integer usuarioId) {
        return proveedorRepository.findByUsuarioId(usuarioId);
    }
}
