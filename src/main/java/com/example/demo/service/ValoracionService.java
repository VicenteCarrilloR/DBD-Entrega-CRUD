package com.example.demo.service;

import com.example.demo.entity.Valoracion;
import com.example.demo.repository.ValoracionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ValoracionService {
    private ValoracionRepository valoracionRepository;

    public ValoracionService(ValoracionRepository valoracionRepository) {
        this.valoracionRepository = valoracionRepository;
    }

    @Transactional(readOnly = true)
    public List<Valoracion> listarTodas(){
        return valoracionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Valoracion> obtenerPorId(Long id){
        return valoracionRepository.findById(id);
    }

    public Valoracion guardar(Valoracion valoracion){
        return valoracionRepository.save(valoracion);
    }

    public void eliminar(Long id){
        valoracionRepository.deleteById(id);
    }

}
