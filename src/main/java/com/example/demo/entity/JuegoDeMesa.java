package com.example.demo.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "juego_de_mesa")
public class JuegoDeMesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_juego")
    private Integer idJuego;

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    private Producto producto;

    @Column(name = "nombre_juego", length = 40)
    private String nombreJuego;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Column(name = "tipo_juego", length = 40)
    private String tipoJuego;

    @Column(name = "categoria", length = 40)
    private String categoria;

    @Column(name = "edad_min")
    private Integer edadMin;

    public JuegoDeMesa(){}

    public JuegoDeMesa(Producto producto, String nombreJuego, String descripcion, String tipoJuego, String categoria, Integer edadMin) {
        this.producto = producto;
        this.nombreJuego = nombreJuego;
        this.descripcion = descripcion;
        this.tipoJuego = tipoJuego;
        this.categoria = categoria;
        this.edadMin = edadMin;
    }

    // Getters and setters

    public Integer getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(Integer idJuego) {
        this.idJuego = idJuego;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getNombreJuego() {
        return nombreJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoJuego() {
        return tipoJuego;
    }

    public void setTipoJuego(String tipoJuego) {
        this.tipoJuego = tipoJuego;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getEdadMin() {
        return edadMin;
    }

    public void setEdadMin(Integer edadMin) {
        this.edadMin = edadMin;
    }
}
