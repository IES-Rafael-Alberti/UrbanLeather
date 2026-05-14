package backend.DTO;

import backend.model.Talla;

public class TallaRegisterDTO {

    private Talla.TallaNombre nombre;
    private int stock;
    private Long productoId;

    public TallaRegisterDTO() {}

    public TallaRegisterDTO(Talla.TallaNombre nombre, int stock, Long productoId) {
        this.nombre = nombre;
        this.stock = stock;
        this.productoId = productoId;
    }

    public Talla.TallaNombre getNombre() { return nombre; }

    public void setNombre(Talla.TallaNombre nombre) { this.nombre = nombre; }

    public int getStock() { return stock; }

    public void setStock(int stock) { this.stock = stock; }

    public Long getProductoId() { return productoId; }

    public void setProductoId(Long productoId) { this.productoId = productoId; }
}