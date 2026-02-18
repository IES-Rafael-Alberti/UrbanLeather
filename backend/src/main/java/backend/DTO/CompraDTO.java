package backend.DTO;

import backend.model.Usuario;

import java.time.LocalDateTime;

public class CompraDTO {

    private int id;
    LocalDateTime fecha;
    String estado;
    double total;

    public CompraDTO(LocalDateTime fecha, String estado, double total) {
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
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
