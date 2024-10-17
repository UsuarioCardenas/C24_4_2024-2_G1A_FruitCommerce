package com.tecsup.demo.paq_controllers;

import com.tecsup.demo.paq_dto.ProductoRequestDTO;
import com.tecsup.demo.paq_model.paq_entity.Categoria;
import com.tecsup.demo.paq_model.paq_entity.Producto;
import com.tecsup.demo.paq_model.paq_entity.Proveedor;
import com.tecsup.demo.paq_service.CategoriaService;
import com.tecsup.demo.paq_service.ProductoService;
import com.tecsup.demo.paq_service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ProveedorService proveedorService;

    // Obtener lista de productos
    @PreAuthorize("hasRole('PROVEEDOR')")
    @GetMapping("/all")
    public ResponseEntity<List<Producto>> getAllProductos() {
        return ResponseEntity.ok(productoService.findAll());
    }

    // Guardar nuevo producto
    @PreAuthorize("hasRole('PROVEEDOR')")
    @PostMapping("/save")
    public ResponseEntity<?> saveProducto(@RequestBody ProductoRequestDTO productoDTO) {
        Categoria categoria = categoriaService.findById(productoDTO.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        Proveedor proveedor = proveedorService.findById(productoDTO.getProveedorId())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setCategoria(categoria);
        producto.setProveedor(proveedor);

        productoService.save(producto);
        return ResponseEntity.ok("Producto guardado con éxito");
    }

    // Editar producto
    @PreAuthorize("hasRole('PROVEEDOR')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProducto(@PathVariable Integer id, @RequestBody ProductoRequestDTO productoDTO) {
        Producto producto = productoService.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Categoria categoria = categoriaService.findById(productoDTO.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        Proveedor proveedor = proveedorService.findById(productoDTO.getProveedorId())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setCategoria(categoria);
        producto.setProveedor(proveedor);

        productoService.save(producto);
        return ResponseEntity.ok("Producto actualizado con éxito");
    }

    // Eliminar producto
    @PreAuthorize("hasRole('PROVEEDOR')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable Integer id) {
        productoService.deleteById(id);
        return ResponseEntity.ok("Producto eliminado con éxito");
    }

    // Obtener lista de categorías (para el dropdown en el frontend)
    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> getAllCategorias() {
        return ResponseEntity.ok(categoriaService.findAll());
    }
}
