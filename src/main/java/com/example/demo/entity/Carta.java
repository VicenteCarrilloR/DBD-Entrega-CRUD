package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "carta")
public class Carta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carta")
    private Integer idCarta;

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    private Producto producto;

    @Column(name = "nombre_carta", length = 40)
    private String nombreCarta;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Column(name = "año")
    private LocalDate año;

    @Column(name = "estado", length = 40)
    private String estado;

    @Column(name = "tipo_carta", length = 40)
    private String tipoCarta;

    public Carta(){}

    public Carta(Integer idCarta, Producto producto, String nombreCarta, String descripcion, LocalDate año, String estado, String tipoCarta) {
        this.idCarta = idCarta;
        this.producto = producto;
        this.nombreCarta = nombreCarta;
        this.descripcion = descripcion;
        this.año = año;
        this.estado = estado;
        this.tipoCarta = tipoCarta;
    }

    public Integer getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(Integer idCarta) {
        this.idCarta = idCarta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getNombreCarta() {
        return nombreCarta;
    }

    public void setNombreCarta(String nombreCarta) {
        this.nombreCarta = nombreCarta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getAño() {
        return año;
    }

    public void setAño(LocalDate año) {
        this.año = año;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoCarta() {
        return tipoCarta;
    }

    public void setTipoCarta(String tipoCarta) {
        this.tipoCarta = tipoCarta;
    }

}
