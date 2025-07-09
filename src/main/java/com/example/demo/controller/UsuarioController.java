package com.example.demo.controller;

import com.example.demo.entity.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:3000")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    //obtenemos todos los usuarios
    
    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerTodosUsuarios(){
        List<Usuario> usuarios = usuarioService.obtenerUsuarios();
        return ResponseEntity.ok(usuarios);
    }
    //obtenemos usuario por id
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id){
        Optional<Usuario> usuario = usuarioService.obtenerUsuarioPorId(id);
        return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    //obtenermos el usuario por email
    @GetMapping("/email")
    public ResponseEntity<Usuario> obtenerUsuariosPorEmail(@RequestParam String email){
        Optional<Usuario> usuario = usuarioService.obtenerUsuarioPorEmail(email);
        return usuario.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    //creamos un usuario
    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario){
        Usuario newUsuario = usuarioService.guardarUsuario(usuario);
        return ResponseEntity.ok(newUsuario);
    }

    //actualizamos un usuario
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado){
        Usuario usuarioAct =  usuarioService.obtenerUsuarioPorId(id).orElse(null);
        if(usuarioAct != null){
            usuarioAct.setNombre_user(usuarioActualizado.getNombre_user());
            usuarioAct.setCorreoUser(usuarioActualizado.getCorreoUser());
            usuarioAct.setClave(usuarioActualizado.getClave());
            usuarioAct.setCalle(usuarioActualizado.getCalle());
            usuarioAct.setNro_depto(usuarioActualizado.getNro_depto());
            usuarioAct.setNro_calle(usuarioActualizado.getNro_calle());
            usuarioAct.setRegion(usuarioActualizado.getRegion());
            usuarioAct.setCiudad(usuarioActualizado.getCiudad());
            usuarioService.guardarUsuario(usuarioAct);
            return ResponseEntity.ok(usuarioAct);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    //eliminamos un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id){
        Optional<Usuario> usuario = usuarioService.obtenerUsuarioPorId(id);
        if(usuario.isPresent()){
            usuarioService.eliminarUsuario(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
