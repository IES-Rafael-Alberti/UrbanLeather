package backend.DTO;

import java.math.BigDecimal;
import java.util.List;

public class ProductoDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private String color;
    private String imagen_url;
    private String categoriaNombre;

    private Long categoriaId;

    private List<TallaDTO> tallas;

    public ProductoDTO(Long id, String nombre, String descripcion, BigDecimal precio,
                       String color, String imagen_url, String categoriaNombre) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.color = color;
        this.imagen_url = imagen_url;
        this.categoriaNombre = categoriaNombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public List<TallaDTO> getTallas() {
        return tallas;
    }

    public void setTallas(List<TallaDTO> tallas) {
        this.tallas = tallas;
    }
}