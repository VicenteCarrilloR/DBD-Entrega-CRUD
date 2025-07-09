package com.example.demo.controller;

import com.example.demo.entity.Rol;
import com.example.demo.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "http://localhost:3000")
public class RolController {
    @Autowired
    private RolService rolService;

    //obtenemos todos los roles
    @GetMapping
    public ResponseEntity<List<Rol>> obtenerRoles() {
        List<Rol> roles = rolService.encontrarRoles();
        return ResponseEntity.ok(roles);
    }
    //encontrar por id
    @GetMapping("/{id}")
    public ResponseEntity<Rol> obtenerRol(@PathVariable Long id) {
        Optional<Rol> rol = rolService.encontrarRol(id);
        return rol.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //creamos un rol
    @PostMapping
    public ResponseEntity<Rol> crearRol(@RequestBody Rol rol){
        Rol newRol = rolService.guardarRol(rol);
        return ResponseEntity.ok(newRol);
    }
    //actualizar rol
    @PutMapping
    public ResponseEntity<Rol> actualizarRol(@PathVariable Long id_rol,@RequestBody Rol rolActualizado){
        Rol rolAct = rolService.encontrarRol(id_rol).orElse(null);
        if(rolAct != null){
            rolAct.setAdmin(rolActualizado.getAdmin());
            rolAct.setCliente(rolActualizado.getCliente());
            rolAct.setJefe_tienda(rolActualizado.getJefe_tienda());
            return ResponseEntity.ok(rolAct);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    //eliminar un rol
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@RequestBody Long rol_id){
        Optional<Rol> rol = rolService.encontrarRol(rol_id);
        if(rol.isPresent()){
            rolService.borrarRol(rol_id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
