package backend.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "tallas",
        uniqueConstraints = @UniqueConstraint(columnNames = {"producto_id", "nombre"})
)
public class Talla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TallaNombre nombre;

    @Column(nullable = false)
    private int stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    public enum TallaNombre {
        S, M, L, XL
    }

    public Talla() {}

    public Talla(TallaNombre nombre, int stock, Producto producto) {
        this.nombre = nombre;
        this.stock = stock;
        this.producto = producto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TallaNombre getNombre() {
        return nombre;
    }

    public void setNombre(TallaNombre nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}