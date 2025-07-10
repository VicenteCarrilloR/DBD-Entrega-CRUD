package com.example.demo.controller;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.example.demo.entity.Compra;
import com.example.demo.entity.CompraProducto;
import com.example.demo.entity.CompraProductoId;
import com.example.demo.service.CompraProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/compraproducto")
public class CompraProductoController {

    @Autowired
    private CompraProductoService compraProductoService;

    @GetMapping
    public ResponseEntity<List<CompraProducto>> obtenerTodos() {
        return ResponseEntity.ok(compraProductoService.obtenerTodos());
    }

    @GetMapping("/{idCompra}/{idProducto}")
    public ResponseEntity<CompraProducto> obtenerPorId(@PathVariable Long idCompra, @PathVariable Long idProducto) {
        CompraProductoId id = new CompraProductoId(idCompra, idProducto);
        Optional<CompraProducto> compra = compraProductoService.obtenerPorId(id);
        if (compra.isPresent()) {
            return ResponseEntity.ok(compra.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CompraProducto> crear(@RequestBody CompraProducto compra) {
        return ResponseEntity.ok(compraProductoService.guardar(compra));
    }

    @DeleteMapping("/{idCompra}/{idProducto}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idCompra, @PathVariable Long idProducto) {
        CompraProductoId id = new CompraProductoId(idCompra, idProducto);
        if (compraProductoService.obtenerPorId(id).isPresent()) {
            compraProductoService.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
