package entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CompraProductoId implements Serializable {

    private Long id_compra;
    private Long id_producto;

    public CompraProductoId() {
    }
    public CompraProductoId(Long id_compra, Long id_producto) {
        this.id_compra = id_compra;
        this.id_producto = id_producto;
    }

    public Long getId_compra() {
        return id_compra;
    }

    public void setId_compra(Long id_compra) {
        this.id_compra = id_compra;
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
        if (!(o instanceof CompraProductoId)) return false;
        CompraProductoId that = (CompraProductoId) o;
        return Objects.equals(id_compra, that.id_compra) && Objects.equals(id_producto, that.id_producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_compra, id_producto);
    }
}