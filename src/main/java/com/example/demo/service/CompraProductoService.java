package com.example.demo.service;

import com.example.demo.entity.CompraProducto;
import com.example.demo.entity.CompraProductoId;
import com.example.demo.repository.CompraProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CompraProductoService {

    @Autowired
    private CompraProductoRepository compraProductoRepository;

    @Transactional(readOnly = true)
    public List<CompraProducto> obtenerTodos() {
        return compraProductoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<CompraProducto> obtenerPorId(CompraProductoId id) {
        return compraProductoRepository.findById(id);
    }

    @Transactional
    public CompraProducto guardar(CompraProducto compra) {
        return compraProductoRepository.save(compra);
    }

    @Transactional
    public void eliminar(CompraProductoId id) {
        compraProductoRepository.deleteById(id);
    }
}
