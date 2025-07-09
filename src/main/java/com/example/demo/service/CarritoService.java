package com.example.demo.service;


import com.example.demo.entity.Carrito;
import com.example.demo.repository.CarritoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    public List<Carrito> listarTodos() {
        return carritoRepository.findAll();
    }

    public Carrito obtenerPorId(Long id) {
        return carritoRepository.findById(id).orElse(null);
    }

    public Carrito guardar(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    public void eliminar(Long id) {
        carritoRepository.deleteById(id);
    }
}
