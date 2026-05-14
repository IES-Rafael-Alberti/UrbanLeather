package backend.DTO;

public class CarritoItemDTO {

    private Long productoId;
    private String nombreProducto;
    private String talla;
    private int cantidad;

    public CarritoItemDTO() {}

    public CarritoItemDTO(Long productoId, String nombreProducto, String talla, int cantidad) {
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.talla = talla;
        this.cantidad = cantidad;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
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
}