package com.example.demo.service;

import com.example.demo.entity.Tienda;
import com.example.demo.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TiendaService {
    @Autowired
    private TiendaRepository tiendaRepository;

    public TiendaService(TiendaRepository tiendaRepository) {
        this.tiendaRepository = tiendaRepository;
    }

    @Transactional(readOnly = true)
    public List<Tienda> listarTodas() {
        return tiendaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Tienda> obtenerPorId(Long id) {
        return tiendaRepository.findById(id);
    }

    public Tienda guardar(Tienda tienda) {
        return tiendaRepository.save(tienda);
    }

    public void eliminar(Long id) {
        tiendaRepository.deleteById(id);
    }
}
