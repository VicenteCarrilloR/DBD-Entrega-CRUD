package com.example.demo.controller;

import com.example.demo.entity.CarritoProducto;
import com.example.demo.entity.CarritoProductoId;
import com.example.demo.service.CarritoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carritoproducto")
public class CarritoProductoController {

    @Autowired
    private CarritoProductoService carritoProductoService;

    @GetMapping
    public List<CarritoProducto> listarCarritoProductos() {
        return carritoProductoService.listarTodos();
    }

    @GetMapping("/{idCarrito}/{idProducto}")
    public ResponseEntity<CarritoProducto> obtener(@PathVariable Long idCarrito, @PathVariable Long idProducto) {
        CarritoProductoId id = new CarritoProductoId(idCarrito, idProducto);
        CarritoProducto cp = carritoProductoService.obtenerPorId(id);
        if (cp != null) {
            return ResponseEntity.ok(cp);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public CarritoProducto agregarProducto(@RequestBody CarritoProducto carritoProducto) {
        return carritoProductoService.guardar(carritoProducto);
    }

    @DeleteMapping("/{idCarrito}/{idProducto}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idCarrito, @PathVariable Long idProducto) {
        CarritoProductoId id = new CarritoProductoId(idCarrito, idProducto);
        carritoProductoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
