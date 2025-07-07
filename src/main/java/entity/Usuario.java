package entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id_usuario;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2 ,max =50,message = "EL nombre debe tener entre 2 y 50 caracteres")
    @Column(nullable = false,name = "nombre_user")
    private String nombre_user;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El mail debe ser valido")
    @Column(nullable = false, unique = true,name = "correo_user")
    private String correo_user;

    @NotBlank(message = "La clave es obligatorio")
    @Size(min=8, message = "La clave debe tener al menos 8 caracteres")
    @Column(nullable = false,name = "clave")
    private String clave;

    @Column(name =  "calle")
    private String calle;

    @Column(name =  "nro_depto")
    private Integer nro_depto;

    @Column(name =  "nro_calle")
    private Integer nro_calle;

    @Column(name =  "region")
    private String region;

    @Column(name =  "cuidad")
    private String cuidad;

    @OneToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;

    public Usuario() {
    }
    public Usuario(Long id_usuario,String nombre_user, String correo_user,String clave,
                   String calle, Integer nro_depto, Integer nro_calle, String region, String cuidad, Rol rol) {
        this.id_usuario = id_usuario;
        this.nombre_user = nombre_user;
        this.correo_user = correo_user;
        this.clave = clave;
        this.calle = calle;
        this.nro_depto = nro_depto;
        this.nro_calle = nro_calle;
        this.region = region;
        this.cuidad = cuidad;
        this.rol = rol;

    }
    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_user() {
        return nombre_user;
    }

    public void setNombre_user(String nombre_user) {
        this.nombre_user = nombre_user;
    }

    public String getCorreo_user() {
        return correo_user;
    }

    public void setCorreo_user(String correo_user) {
        this.correo_user = correo_user;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNro_depto() {
        return nro_depto;
    }

    public void setNro_depto(Integer nro_depto) {
        this.nro_depto = nro_depto;
    }

    public Integer getNro_calle() {
        return nro_calle;
    }

    public void setNro_calle(Integer nro_calle) {
        this.nro_calle = nro_calle;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCuidad() {
        return cuidad;
    }

    public void setCuidad(String cuidad) {
        this.cuidad = cuidad;


    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
