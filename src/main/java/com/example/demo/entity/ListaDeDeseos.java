package com.example.demo.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "lista_deseos")
public class ListaDeDeseos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id_lista;

    @Column(name = "total_lista")
    private Integer totalLista;

    @OneToOne
    @JoinColumn(name = "id_usuario", unique = true)
    private Usuario usuario;

    public ListaDeDeseos() {
    }

    public ListaDeDeseos(Integer totalLista, Usuario usuario) {
        this.totalLista = totalLista;
        this.usuario = usuario;
    }

    public Long getId_lista() {
        return id_lista;
    }

    public void setId_lista(Long id_lista) {
        this.id_lista = id_lista;
    }

    public Integer getTotalLista() {
        return totalLista;
    }

    public void setTotalLista(Integer totalLista) {
        this.totalLista = totalLista;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
