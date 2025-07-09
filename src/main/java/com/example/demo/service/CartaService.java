package com.example.demo.service;

import com.example.demo.entity.Carta;
import com.example.demo.repository.CartaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CartaService {

    @Autowired
    private CartaRepository cartaRepository;

    public List<Carta> listarTodos() {
        return cartaRepository.findAll();
    }

    public Carta obtenerPorId(Long id) {
        return cartaRepository.findById(id).orElse(null);
    }

    public Carta guardar(Carta carta) {
        return cartaRepository.save(carta);
    }

    public void eliminar(Long id) {
        cartaRepository.deleteById(id);
    }
}