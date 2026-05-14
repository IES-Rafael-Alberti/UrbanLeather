package backend.DTO;

public class DetalleCompraDTO {

    private Long compraId;
    private Long productoId;
    private String talla;
    private int cantidad;
    private double precioUnitario;

    public DetalleCompraDTO() {}

    public DetalleCompraDTO(Long compraId, Long productoId, String talla, int cantidad, double precioUnitario) {
        this.compraId = compraId;
        this.productoId = productoId;
        this.talla = talla;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public Long getCompraId() {
        return compraId;
    }

    public void setCompraId(Long compraId) {
        this.compraId = compraId;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}