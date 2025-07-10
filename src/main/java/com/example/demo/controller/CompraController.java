package com.example.demo.controller;

import com.example.demo.entity.Compra;
import com.example.demo.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @GetMapping
    public ResponseEntity<List<Compra>> obtenerTodos() {
        return ResponseEntity.ok(compraService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> obtenerPorId(@PathVariable Long id) {
        Optional<Compra> compra = compraService.obtenerPorId(id);
        if (compra.isPresent()) {
            return ResponseEntity.ok(compra.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Compra> crear(@RequestBody Compra compra) {
        Compra nueva = compraService.guardar(compra);
        return ResponseEntity.ok(nueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compra> actualizar(@PathVariable Long id, @RequestBody Compra compraAct) {
        Optional<Compra> actual = compraService.obtenerPorId(id);
        if (actual.isPresent()) {
            Compra compra = actual.get();
            compra.setFecha(compraAct.getFecha());
            compra.setTotal_compra(compraAct.getTotal_compra());
            compra.setId_tienda(compraAct.getId_tienda());
            compra.setId_mp(compraAct.getId_mp());
            compra.setId_carrito(compraAct.getId_carrito());
            compra.setId_usuario(compraAct.getId_usuario());
            return ResponseEntity.ok(compraService.guardar(compra));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (compraService.obtenerPorId(id).isPresent()) {
            compraService.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
