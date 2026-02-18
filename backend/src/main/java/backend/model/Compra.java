package backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, unique = true)
    private Usuario usuario;
    @Column(nullable = false)
    LocalDateTime fecha;
    @Column(nullable = false)
    String estado;
    @Column(nullable = false)
    double total;

    public Compra() {
    }

    public Compra(Usuario usuario, LocalDateTime fecha, String estado, double total) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
