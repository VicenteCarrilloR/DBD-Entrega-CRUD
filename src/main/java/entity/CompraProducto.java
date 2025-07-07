package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "compra_producto")
public class CompraProducto {

    @EmbeddedId
    private CompraProductoId id;

    @ManyToOne
    @MapsId("id_compra")
    @JoinColumn(name = "id_compra", nullable = false)
    private Compra id_compra;

    @ManyToOne
    @MapsId("id_producto")
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto id_producto;

    @Column(name = "cantidad_compra", nullable = false)
    private Integer cantidad_compra;

    public CompraProducto() {
    }
    public CompraProducto(Compra id_compra, Producto id_producto, Integer cantidad_compra) {
        this.id = id;
        this.id_compra = id_compra;
        this.id_producto = id_producto;
        this.cantidad_compra = cantidad_compra;
    }

    public CompraProductoId getId() {
        return id;
    }

    public void setId(CompraProductoId id) {
        this.id = id;
    }

    public Compra getId_compra() {
        return id_compra;
    }

    public void setId_compra(Compra id_compra) {
        this.id_compra = id_compra;
    }

    public Producto getId_producto() {
        return id_producto;
    }

    public void setId_producto(Producto id_producto) {
        this.id_producto = id_producto;
    }

    public Integer getCantidad_compra() {
        return cantidad_compra;
    }

    public void setCantidad_compra(Integer cantidad_compra) {
        this.cantidad_compra = cantidad_compra;
    }
}