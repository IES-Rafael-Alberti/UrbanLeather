package backend.DTO;

public class CompraRegisterDTO {

    private String username;
    private String estado;
    private double total;

    public CompraRegisterDTO() {}

    public CompraRegisterDTO(String username, String estado, double total) {
        this.username = username;
        this.estado = estado;
        this.total = total;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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