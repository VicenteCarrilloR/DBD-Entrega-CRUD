package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_compra;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario id_usuario;

    @OneToOne
    @JoinColumn(name = "id_carrito", nullable = false)
    private Carrito id_carrito;

    @ManyToOne
    @JoinColumn(name = "id_mp", nullable = false)
    private MedioDePago id_mp;

    @ManyToOne
    @JoinColumn(name = "id_tienda", nullable = false)
    private Tienda id_tienda;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false)
    private Integer total_compra;

    public Compra() {
    }
    public Compra(Integer total_compra, LocalDateTime fecha, Tienda id_tienda, MedioDePago id_mp, Carrito id_carrito, Usuario id_usuario) {
        this.total_compra = total_compra;
        this.fecha = fecha;
        this.id_tienda = id_tienda;
        this.id_mp = id_mp;
        this.id_carrito = id_carrito;
        this.id_usuario = id_usuario;
    }

    public Integer getTotal_compra() {
        return total_compra;
    }

    public void setTotal_compra(Integer total_compra) {
        this.total_compra = total_compra;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Tienda getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(Tienda id_tienda) {
        this.id_tienda = id_tienda;
    }

    public MedioDePago getId_mp() {
        return id_mp;
    }

    public void setId_mp(MedioDePago id_mp) {
        this.id_mp = id_mp;
    }

    public Carrito getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(Carrito id_carrito) {
        this.id_carrito = id_carrito;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public long getId_compra() {
        return id_compra;
    }

    public void setId_compra(long id_compra) {
        this.id_compra = id_compra;
    }
}
