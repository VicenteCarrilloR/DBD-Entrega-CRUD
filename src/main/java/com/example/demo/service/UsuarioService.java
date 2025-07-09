package com.example.demo.service;


import com.example.demo.entity.Usuario;

import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    //obtener los usuarios
    @Transactional(readOnly = true)
    public List<Usuario> obtenerUsuarios(){
        return usuarioRepository.findAll();
    }

    //  obtener por id
    @Transactional(readOnly = true)
    public Optional<Usuario> obtenerUsuarioPorId(Long id){
        return usuarioRepository.findById(id);
    }
    //obtener por email
    @Transactional(readOnly = true)
    public Optional<Usuario> obtenerUsuarioPorEmail(String email){
        return usuarioRepository.findByCorreo(email);
    }
    //guardar un usuario
    @Transactional
    public Usuario guardarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    //eliminar un usuario
    @Transactional
    public void eliminarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

}
