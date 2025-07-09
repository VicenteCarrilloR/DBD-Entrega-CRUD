package com.example.demo.service;

import com.example.demo.entity.CarritoProducto;
import com.example.demo.entity.CarritoProductoId;
import com.example.demo.repository.CarritoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoProductoService {

    @Autowired
    private CarritoProductoRepository carritoProductoRepository;

    public List<CarritoProducto> listarTodos() {
        return carritoProductoRepository.findAll();
    }

    public CarritoProducto obtenerPorId(CarritoProductoId id) {
        return carritoProductoRepository.findById(id).orElse(null);
    }

    public CarritoProducto guardar(CarritoProducto carritoProducto) {
        Long idCarrito = carritoProducto.getCarrito().getId_carrito();
        Long idProducto = carritoProducto.getProducto().getIdProducto();

        CarritoProductoId id = new CarritoProductoId(idCarrito, idProducto);
        carritoProducto.setId(id);  // ← Esto es lo que le faltaba

        return carritoProductoRepository.save(carritoProducto);
    }

    public void eliminar(CarritoProductoId id) {
        carritoProductoRepository.deleteById(id);
    }
}
