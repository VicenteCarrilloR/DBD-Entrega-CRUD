package entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "valoracion")
public class Valoracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_valoracion;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto id_producto;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario id_usuario;

    @Column(nullable = false, name = "comentario")
    private String comentario;

    @NotBlank(message = "La puntuacion es obligatoria")
    @Size(min = 1, max = 1, message = "La puntuacion debe ir de 1 a 5")
    @Column(nullable = false, name = "puntuacion")
    private Integer puntuacion;

    @Column(nullable = false, name = "valorado")
    private boolean valorado;

    public Valoracion() {}

    public Valoracion(Long id_valoracion, Producto id_producto, Usuario id_usuario, String comentario, Integer puntuacion, boolean valorado) {
        this.id_valoracion = id_valoracion;
        this.id_producto = id_producto;
        this.id_usuario = id_usuario;
        this.comentario = comentario;
        this.puntuacion = puntuacion;
        this.valorado = valorado;
    }

    //Getters

    public Long getId_valoracion() {
        return id_valoracion;
    }

    public Producto getId_producto() {
        return id_producto;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public String getComentario() {
        return comentario;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public boolean isValorado() {
        return valorado;
    }

    //Setters
    
    public void setId_valoracion(Long id_valoracion) {
        this.id_valoracion = id_valoracion;
    }

    public void setId_producto(Producto id_producto) {
        this.id_producto = id_producto;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setValorado(boolean valorado) {
        this.valorado = valorado;
    }
}
