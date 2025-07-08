package com.example.demo.entity;
import jakarta.persistence.*;

@Entity
@Table(name="producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @ManyToOne
    @JoinColumn(name = "id_tienda", referencedColumnName = "id_tienda")
    private Tienda tienda;

    @Column(name = "precio")
    private Integer precio;

    @Column(name = "url_imagen", length = 100)
    private String urlImagen;

    @Column(name = "stock")
    private Integer stock;

    public Producto() {}

    public Producto(Tienda tienda, Integer precio, String urlImagen, Integer stock) {
        this.tienda = tienda;
        this.precio = precio;
        this.urlImagen = urlImagen;
        this.stock = stock;
    }

    public Integer getIdProducto(){
        return idProducto;
    }

    public void setIdProducto(Integer idProducto){
        this.idProducto = idProducto;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
