package com.example.demo.service;

import com.example.demo.entity.Rol;
import com.example.demo.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RolService {
    @Autowired
    private RolRepository rolRepository;
    @Transactional(readOnly = true)
    //encontrar los roles (3)
    public List<Rol> encontrarRoles() {
        return rolRepository.findAll();
    }
    @Transactional(readOnly = true)
    //encontrar por id_rol
    public Optional<Rol> encontrarRol(Long rol_id) {
        return rolRepository.findById(rol_id);
    }
    @Transactional
    //guardar un rol
    public Rol guardarRol(Rol rol) {
        return rolRepository.save(rol);
    }
    @Transactional
    //eliminar un rol
    public void borrarRol(Long rol_id) {
        rolRepository.deleteById(rol_id);
    }

}
