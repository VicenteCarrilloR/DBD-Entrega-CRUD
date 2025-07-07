package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CarritoProductoId implements Serializable {

    @Column(name = "id_carrito")
    private Long id_carrito;

    @Column(name = "id_producto")
    private Long id_producto;

    public CarritoProductoId() {
    }

    public CarritoProductoId(Long id_carrito, Long id_producto) {
        this.id_carrito = id_carrito;
        this.id_producto = id_producto;
    }

    public Long getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(Long id_carrito) {
        this.id_carrito = id_carrito;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarritoProductoId)) return false;
        CarritoProductoId that = (CarritoProductoId) o;
        return Objects.equals(id_carrito, that.id_carrito) &&
                Objects.equals(id_producto, that.id_producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_carrito, id_producto);
    }
}
