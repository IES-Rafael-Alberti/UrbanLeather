package backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tallas")
public class Talla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany
    @JoinColumn(name = "producto_id", referencedColumnName = "producto_id", nullable = false, unique = true)
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private int stock;

    public Talla() {
    }

    public Talla(String nombre, int stock) {
        this.nombre = nombre;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
