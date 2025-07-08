package com.example.demo.entity;

import jakarta.persistence.*;

import java.security.PrivateKey;

@Entity
@Table(name = "lista_producto")
public class ListaProducto {

    @EmbeddedId
    private ListaProductoId id;

    @ManyToOne
    @MapsId("id_lista")
    @JoinColumn(name = "id_lista")
    private ListaDeDeseos lista;

    @ManyToOne
    @MapsId("id_producto")
    @JoinColumn(name = "id_producto")
    private Producto producto;

    public ListaProducto() {
    }

    public ListaProducto(ListaDeDeseos lista, Producto producto) {
        this.lista = lista;
        this.producto = producto;
    }

    public ListaProductoId getId() {
        return id;
    }

    public void setId(ListaProductoId id) {
        this.id = id;
    }

    public ListaDeDeseos getLista() {
        return lista;
    }

    public void setLista(ListaDeDeseos lista) {
        this.lista = lista;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
