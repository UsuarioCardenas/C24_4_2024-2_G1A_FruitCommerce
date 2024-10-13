package com.tecsup.demo.paq_controllers;

import com.tecsup.demo.paq_dto.CompradorRequestDTO;
import com.tecsup.demo.paq_dto.ProveedorRequestDTO;
import com.tecsup.demo.paq_model.paq_entity.Comprador;
import com.tecsup.demo.paq_model.paq_entity.Proveedor;
import com.tecsup.demo.paq_model.paq_entity.UserRole;
import com.tecsup.demo.paq_model.paq_entity.Usuario;
import com.tecsup.demo.paq_service.CompradorService;
import com.tecsup.demo.paq_service.ProveedorService;
import com.tecsup.demo.paq_service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/controlador_roles") // Cambia según la estructura de tu aplicación
public class RoleController {

    private final UsuarioService usuarioService;
    private final ProveedorService proveedorService;
    private final CompradorService compradorService;

    @Autowired
    public RoleController(UsuarioService usuarioService, ProveedorService proveedorService, CompradorService compradorService) {
        this.usuarioService = usuarioService;
        this.proveedorService = proveedorService;
        this.compradorService = compradorService;
    }

    @PostMapping("/selectRole")
    public ResponseEntity<?> selectRole(@RequestParam("role") String role, @RequestParam("userId") Integer userId) {
        // Buscar el usuario por su ID
        Usuario usuario = usuarioService.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Verificar si el usuario ya tiene un rol diferente a 'NINGUNO'
        if (usuario.getRole() != UserRole.NINGUNO) {
            return ResponseEntity.badRequest().body("No puedes cambiar el rol una vez que ha sido asignado.");
        }

        // Asignar rol dependiendo de la selección
        if ("PROVEEDOR".equalsIgnoreCase(role)) {
            usuario.setRole(UserRole.PROVEEDOR);
            usuarioService.save(usuario); // Actualiza el rol

            // Redirige al formulario de proveedor para completar nombre_empresa
            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create("http://localhost:3000/form-proveedor/" + userId))
                    .build();

        } else if ("COMPRADOR".equalsIgnoreCase(role)) {
            usuario.setRole(UserRole.COMPRADOR);
            usuarioService.save(usuario); // Actualiza el rol

            // Redirige al formulario de comprador para completar nombres, apellidos, DNI
            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create("http://localhost:3000/form-comprador/" + userId))
                    .build();
        }

        // Si el rol no es válido
        return ResponseEntity.badRequest().body("Rol no válido");
    }

    @PostMapping("/saveProveedor")
    public ResponseEntity<?> saveProveedor(@RequestBody ProveedorRequestDTO proveedorRequestDTO) {
        // Buscar el usuario por su ID
        Usuario usuario = usuarioService.findById(proveedorRequestDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        // Actualizar los campos de usuario con los datos del formulario
        usuario.setTelefono(proveedorRequestDTO.getTelefono());
        usuario.setDireccion(proveedorRequestDTO.getDireccion());
        usuario.setRUC(proveedorRequestDTO.getRuc());
        // Guardar los datos actualizados del usuario
        usuarioService.save(usuario);
        // Crear el proveedor y asignar los valores
        Proveedor proveedor = new Proveedor();
        proveedor.setUsuario(usuario);
        proveedor.setNombreEmpresa(proveedorRequestDTO.getNombreEmpresa());
        // Guardar el proveedor
        proveedorService.save(proveedor);
        return ResponseEntity.ok("Proveedor guardado con éxito");
    }

    @PostMapping("/saveComprador")
    public ResponseEntity<?> saveComprador(@RequestBody CompradorRequestDTO compradorRequestDTO) {
        // Buscar el usuario por su ID
        Usuario usuario = usuarioService.findById(compradorRequestDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        // Actualizar los campos de usuario con los datos del formulario
        usuario.setTelefono(compradorRequestDTO.getTelefono());
        usuario.setDireccion(compradorRequestDTO.getDireccion());
        usuario.setRUC(compradorRequestDTO.getRuc());
        // Guardar los datos actualizados del usuario
        usuarioService.save(usuario);
        // Crear el comprador y asignar los valores
        Comprador comprador = new Comprador();
        comprador.setUsuario(usuario);
        comprador.setNombres(compradorRequestDTO.getNombres());
        comprador.setApellidos(compradorRequestDTO.getApellidos());
        comprador.setDni(compradorRequestDTO.getDni());
        // Guardar el comprador
        compradorService.save(comprador);
        return ResponseEntity.ok("Comprador guardado con éxito");
    }
}
