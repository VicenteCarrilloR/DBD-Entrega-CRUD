package com.example.demo.dto;

public class UsuarioResponse {
    private Long id;
    private String correo;
    private String nombre;
    private String role;

    public UsuarioResponse() {}

    public UsuarioResponse(Long id, String correo, String nombre, String role) {
        this.id = id;
        this.correo = correo;
        this.nombre = nombre;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
