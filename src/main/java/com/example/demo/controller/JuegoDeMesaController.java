package com.example.demo.controller;

import com.example.demo.entity.JuegoDeMesa;
import com.example.demo.service.JuegoDeMesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/juegosmesa")
public class JuegoDeMesaController {

    @Autowired
    private JuegoDeMesaService juegoDeMesaService;

    @GetMapping
    public List<JuegoDeMesa> listarJuegos() {
        return juegoDeMesaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JuegoDeMesa> obtenerJuego(@PathVariable Long id) {
        JuegoDeMesa juego = juegoDeMesaService.obtenerPorId(id);
        if (juego != null) {
            return ResponseEntity.ok(juego);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public JuegoDeMesa crearJuego(@RequestBody JuegoDeMesa juegoDeMesa) {
        return juegoDeMesaService.guardar(juegoDeMesa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JuegoDeMesa> actualizarJuego(@PathVariable Long id, @RequestBody JuegoDeMesa juegoNuevo) {
        JuegoDeMesa existente = juegoDeMesaService.obtenerPorId(id);
        if (existente != null) {
            // Actualiza todos los campos editables
            existente.setProducto(juegoNuevo.getProducto());
            existente.setNombreJuego(juegoNuevo.getNombreJuego());
            existente.setDescripcion(juegoNuevo.getDescripcion());
            existente.setTipoJuego(juegoNuevo.getTipoJuego());
            existente.setCategoria(juegoNuevo.getCategoria());
            existente.setEdadMin(juegoNuevo.getEdadMin());

            return ResponseEntity.ok(juegoDeMesaService.guardar(existente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarJuego(@PathVariable Long id) {
        juegoDeMesaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

