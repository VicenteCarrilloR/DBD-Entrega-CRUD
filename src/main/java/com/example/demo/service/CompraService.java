package com.example.demo.service;

import com.example.demo.entity.Compra;
import com.example.demo.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Transactional(readOnly = true)
    public List<Compra> obtenerTodos() {
        return compraRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Compra> obtenerPorId(Long id) {
        return compraRepository.findById(id);
    }

    @Transactional
    public Compra guardar(Compra compra) {
        return compraRepository.save(compra);
    }

    @Transactional
    public void eliminar(Long id) {
        compraRepository.deleteById(id);
    }
}