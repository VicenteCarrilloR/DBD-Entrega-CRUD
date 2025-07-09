package com.example.demo.service;

import com.example.demo.entity.JuegoDeMesa;
import com.example.demo.repository.JuegoDeMesaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class JuegoDeMesaService {

    @Autowired
    private JuegoDeMesaRepository juegoDeMesaRepository;

    public List<JuegoDeMesa> listarTodos() {
        return juegoDeMesaRepository.findAll();
    }

    public JuegoDeMesa obtenerPorId(Long id) {
        return juegoDeMesaRepository.findById(id).orElse(null);
    }

    public JuegoDeMesa guardar(JuegoDeMesa juegoDeMesa) {
        return juegoDeMesaRepository.save(juegoDeMesa);
    }

    public void eliminar(Long id) {
        juegoDeMesaRepository.deleteById(id);
    }
}