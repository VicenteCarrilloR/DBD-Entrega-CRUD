package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ListaProductoId {

    @Column(name = "id_lista")
    private Long id_lista;

    @Column(name = "id_producto")
    private Long id_producto;

    public ListaProductoId() {
    }

    public ListaProductoId(Long id_lista, Long id_producto) {
        this.id_lista = id_lista;
        this.id_producto = id_producto;
    }

    public Long getId_lista() {
        return id_lista;
    }

    public void setId_lista(Long id_lista) {
        this.id_lista = id_lista;
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
        if (!(o instanceof ListaProductoId)) return false;
        ListaProductoId that = (ListaProductoId) o;
        return Objects.equals(id_lista, that.id_lista) &&
                Objects.equals(id_producto, that.id_producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_lista, id_producto);
    }
}
