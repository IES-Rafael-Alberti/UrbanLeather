package backend.DTO;

import java.math.BigDecimal;
import java.util.List;

public class ProductoRegisterDTO {

    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private String color;
    private String imagen_url;
    private Long categoriaId;

    private List<TallaRegisterDTO> tallas;

    public ProductoRegisterDTO() {}

    public ProductoRegisterDTO(String nombre, String descripcion, BigDecimal precio,
                               String color, String imagen_url, Long categoriaId,
                               List<TallaRegisterDTO> tallas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.color = color;
        this.imagen_url = imagen_url;
        this.categoriaId = categoriaId;
        this.tallas = tallas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImagen_url() {
        return imagen_url;
    }

    public void setImagen_url(String imagen_url) {
        this.imagen_url = imagen_url;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public List<TallaRegisterDTO> getTallas() {
        return tallas;
    }

    public void setTallas(List<TallaRegisterDTO> tallas) {
        this.tallas = tallas;
    }
}