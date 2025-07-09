package com.example.demo.controller;

import com.example.demo.entity.Carta;
import com.example.demo.service.CartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartas")
public class CartaController {

    @Autowired
    private CartaService cartaService;

    @GetMapping
    public List<Carta> listarCartas() {
        return cartaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carta> obtenerCarta(@PathVariable Long id) {
        Carta carta = cartaService.obtenerPorId(id);
        if (carta != null) {
            return ResponseEntity.ok(carta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Carta crearCarta(@RequestBody Carta carta) {
        return cartaService.guardar(carta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carta> actualizarCarta(@PathVariable Long id, @RequestBody Carta cartaNueva) {
        Carta existente = cartaService.obtenerPorId(id);
        if (existente != null) {
            // Actualiza todos los campos menos el id
            existente.setProducto(cartaNueva.getProducto());
            existente.setNombreCarta(cartaNueva.getNombreCarta());
            existente.setDescripcion(cartaNueva.getDescripcion());
            existente.setAño(cartaNueva.getAño());
            existente.setEstado(cartaNueva.getEstado());
            existente.setTipoCarta(cartaNueva.getTipoCarta());

            return ResponseEntity.ok(cartaService.guardar(existente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCarta(@PathVariable Long id) {
        cartaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}


