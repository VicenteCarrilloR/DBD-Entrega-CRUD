package com.example.demo.controller;


import com.example.demo.entity.Valoracion;
import com.example.demo.service.ValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/valoracion")
public class ValoracionController {
    @Autowired
    private ValoracionService valoracionService;

    public ValoracionController(ValoracionService valoracionService) {
        this.valoracionService = valoracionService;
    }

    @GetMapping
    public List<Valoracion> listar(){
        return valoracionService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Valoracion> obtenerPorId(@PathVariable Long id){
        return valoracionService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Valoracion crear(@RequestBody Valoracion valoracion){
        return valoracionService.guardar(valoracion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Valoracion> actualizar(@PathVariable Long id, @RequestBody Valoracion nuevavaloracion){
        return valoracionService.obtenerPorId(id).map(valoracion -> {
            valoracion.setComentario(nuevavaloracion.getComentario());
            valoracion.setPuntuacion(nuevavaloracion.getPuntuacion());
            return ResponseEntity.ok(valoracionService.guardar(valoracion));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        if (valoracionService.obtenerPorId(id).isPresent()) {
            valoracionService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return  ResponseEntity.notFound().build();
    }

}
