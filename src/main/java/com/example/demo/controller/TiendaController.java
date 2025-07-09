package com.example.demo.controller;

import com.example.demo.entity.Tienda;
import com.example.demo.service.TiendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tienda")
public class TiendaController {
    private TiendaService tiendaService;

    public TiendaController(TiendaService tiendaService) {
        this.tiendaService = tiendaService;
    }

    @GetMapping
    public List<Tienda> listar() {
        return tiendaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tienda> obtenerPorId(@PathVariable Long id) {
        return tiendaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tienda crear(@RequestBody Tienda tienda) {
        return tiendaService.guardar(tienda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tienda> actualizar(@PathVariable Long id, @RequestBody Tienda nuevatienda) {
        return tiendaService.obtenerPorId(id).map(tienda -> {
            tienda.setNombre_t(nuevatienda.getNombre_t());
            tienda.setCalle(nuevatienda.getCalle());
            tienda.setNro_u(nuevatienda.getNro_u());
            tienda.setNro_calle(nuevatienda.getNro_calle());
            tienda.setRegion(nuevatienda.getRegion());
            tienda.setCiudad(nuevatienda.getCiudad());
            return ResponseEntity.ok(tiendaService.guardar(tienda));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (tiendaService.obtenerPorId(id).isPresent()) {
            tiendaService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
