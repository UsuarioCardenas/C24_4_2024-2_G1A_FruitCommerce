package com.tecsup.demo.paq_service.paq_impl;
import com.tecsup.demo.paq_model.paq_dao.ProductoRepository;
import com.tecsup.demo.paq_model.paq_entity.Producto;
import com.tecsup.demo.paq_service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public void save(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public Optional<Producto> findById(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public void update(Integer id, Producto producto) {
        if (productoRepository.existsById(id)) {
            producto.setIdProducto(id); // Asegúrate de establecer el ID del producto
            productoRepository.save(producto);
        } else {
            throw new RuntimeException("Producto no encontrado");
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Producto no encontrado");
        }
    }

    @Override
    public List<Producto> findByNombre(String nombre) {
        return productoRepository.findByNombre(nombre);
    }

    @Override
    public List<Producto> findByCategoriaId(Integer categoriaId) {
        return productoRepository.findByCategoriaId(categoriaId);
    }

    @Override
    public List<Producto> findByProveedorId(Integer proveedorId) {
        return productoRepository.findByProveedorId(proveedorId);
    }
}
