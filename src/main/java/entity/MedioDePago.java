package entity;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "medio_de_pago")
public class MedioDePago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_mp;

    @Column(nullable = false)
    private boolean credito;

    @Column(nullable = false)
    private boolean debito;

    @Column(nullable = false)
    private boolean transferencia;

    public MedioDePago() {
    }
    public MedioDePago(boolean transferencia, boolean debito, boolean credito) {
        this.transferencia = transferencia;
        this.debito = debito;
        this.credito = credito;
        this.id_mp = id_mp;
    }

    public Long getId_mp() {
        return id_mp;
    }

    public void setId_mp(Long id_mp) {
        this.id_mp = id_mp;
    }

    public boolean isTransferencia() {
        return transferencia;
    }

    public void setTransferencia(boolean transferencia) {
        this.transferencia = transferencia;
    }

    public boolean isDebito() {
        return debito;
    }

    public void setDebito(boolean debito) {
        this.debito = debito;
    }

    public boolean isCredito() {
        return credito;
    }

    public void setCredito(boolean credito) {
        this.credito = credito;
    }
}