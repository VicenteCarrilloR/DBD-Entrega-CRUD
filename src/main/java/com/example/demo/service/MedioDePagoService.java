package com.example.demo.service;

import com.example.demo.entity.MedioDePago;
import com.example.demo.repository.MedioDePagoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MedioDePagoService {

    @Autowired
    private MedioDePagoRepository medioDePagoRepository;

    @Transactional(readOnly = true)
    public List<MedioDePago> obtenerTodos() {
        return medioDePagoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<MedioDePago> obtenerPorId(Long id) {
        return medioDePagoRepository.findById(id);
    }

    @Transactional
    public MedioDePago guardar(MedioDePago medio) {
        return medioDePagoRepository.save(medio);
    }

    @Transactional
    public void eliminar(Long id) {
        medioDePagoRepository.deleteById(id);
    }
}
