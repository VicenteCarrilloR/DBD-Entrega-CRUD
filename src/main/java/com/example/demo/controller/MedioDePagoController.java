package com.example.demo.controller;

import com.example.demo.entity.MedioDePago;
import com.example.demo.service.MedioDePagoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mediosdepago")
@CrossOrigin(origins = "http://localhost:3000")
public class MedioDePagoController {

    @Autowired
    private MedioDePagoService medioDePagoService;

    @GetMapping
    public List<MedioDePago> obtenerTodos() {
        return medioDePagoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedioDePago> obtenerPorId(@PathVariable Long id) {
        Optional<MedioDePago> medio = medioDePagoService.obtenerPorId(id);
        if (medio.isPresent()) {
            return ResponseEntity.ok(medio.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public MedioDePago crear(@RequestBody MedioDePago medio) {
        return medioDePagoService.guardar(medio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedioDePago> actualizar(@PathVariable Long id, @RequestBody MedioDePago nuevoMedio) {
        Optional<MedioDePago> medioExistente = medioDePagoService.obtenerPorId(id);

        if (medioExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        MedioDePago medio = medioExistente.get();
        medio.setCredito(nuevoMedio.isCredito());
        medio.setDebito(nuevoMedio.isDebito());
        medio.setTransferencia(nuevoMedio.isTransferencia());

        MedioDePago medioGuardado = medioDePagoService.guardar(medio);
        return ResponseEntity.ok(medioGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Optional<MedioDePago> medio = medioDePagoService.obtenerPorId(id);

        if (medio.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        medioDePagoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
