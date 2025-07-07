package entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tienda")
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tienda;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario id_usuario;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 40, message = "El nombre debe tener entre 2 y 40 caracteres")
    @Column(nullable = false, name = "nombre_t")
    private String nombre_t;

    @Column(nullable = false, name = "calle")
    private String calle;

    @Column(nullable = false, name = "nro_u")
    private Integer nro_u;

    @Column(nullable = false, name = "nro_calle")
    private Integer nro_calle;

    @Column(nullable = false, name = "region")
    private String region;

    @Column(nullable = false, name = "ciudad")
    private String ciudad;

    public Tienda() {}

    public Tienda(Long id_tienda, Usuario id_usuario, String nombre_t, String calle, Integer nro_u, Integer nro_calle, String region, String ciudad) {
        this.id_tienda = id_tienda;
        this.id_usuario = id_usuario;
        this.nombre_t = nombre_t;
        this.calle = calle;
        this.nro_u = nro_u;
        this.nro_calle = nro_calle;
        this.region = region;
        this.ciudad = ciudad;
    }

    //Getters

    public Long getId_tienda() {
        return id_tienda;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public String getNombre_t() {
        return nombre_t;
    }

    public String getCalle() {
        return calle;
    }

    public Integer getNro_u() {
        return nro_u;
    }

    public Integer getNro_calle() {
        return nro_calle;
    }

    public String getRegion() {
        return region;
    }

    public String getCiudad() {
        return ciudad;
    }

    //Setters

    public void setId_tienda(Long id_tienda) {
        this.id_tienda = id_tienda;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setNombre_t(String nombre_t) {
        this.nombre_t = nombre_t;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNro_u(Integer nro_u) {
        this.nro_u = nro_u;
    }

    public void setNro_calle(Integer nro_calle) {
        this.nro_calle = nro_calle;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
