package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rol;

    @Column(name = "admin")
    private Boolean admin;

    @Column(name = "jefe_tienda")
    private Boolean jefe_tienda;

    @Column(name = "cliente")
    private Boolean cliente;
    
    public Rol() {

    }
    
    public Rol( Boolean admin, Boolean jefe_tienda, Boolean cliente) {

        this.admin = admin;
        this.jefe_tienda = jefe_tienda;
        this.cliente = cliente;
    }

    public Long getId_rol() {
        return id_rol;
    }

    public void setId_rol(Long id_rol) {
        this.id_rol = id_rol;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getJefe_tienda() {
        return jefe_tienda;
    }

    public void setJefe_tienda(Boolean jefe_tienda) {
        this.jefe_tienda = jefe_tienda;
    }

    public Boolean getCliente() {
        return cliente;
    }

    public void setCliente(Boolean cliente) {
        this.cliente = cliente;
    }
}
