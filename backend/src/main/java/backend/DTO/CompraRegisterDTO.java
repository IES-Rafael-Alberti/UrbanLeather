package backend.DTO;

import backend.model.Usuario;

import java.time.LocalDateTime;

public class CompraRegisterDTO {

    private int id;
    private Usuario usuario;
    LocalDateTime fecha;
    String estado;
    double total;

    public CompraRegisterDTO(Usuario usuario, LocalDateTime fecha, String estado, double total) {
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
