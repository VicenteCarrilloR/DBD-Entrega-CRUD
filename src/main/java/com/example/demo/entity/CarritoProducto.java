package com.example.demo.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "carrito_producto")
public class CarritoProducto {

    @EmbeddedId
    private CarritoProductoId id;

    @ManyToOne
    @MapsId("id_carrito")
    @JoinColumn(name = "id_carrito")
    private Carrito carrito;


    @ManyToOne
    @MapsId("id_producto")
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @Column(name = "cantidad")
    private Integer cantidad;

    public CarritoProducto() {
    }

    public CarritoProducto(Carrito carrito, Producto producto, Integer cantidad) {
        this.carrito = carrito;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public CarritoProductoId getId() {
        return id;
    }

    public void setId(CarritoProductoId id) {
        this.id = id;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
