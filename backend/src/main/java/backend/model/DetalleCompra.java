package backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detalleCompra")
public class DetalleCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany
    @JoinColumn(name = "compra_id", referencedColumnName = "compra_id", nullable = false, unique = true)
    private Compra compra;
    @OneToMany
    @JoinColumn(name = "producto_id", referencedColumnName = "producto_id", nullable = false, unique = true)
    private Producto producto;
    @Column(nullable = false)
    private String talla;
    @Column(nullable = false)
    private int cantidad;
    @Column(nullable = false)
    private double precio_unitario;

    public DetalleCompra() {
    }

    public DetalleCompra(Compra compra, Producto producto, String talla, int cantidad, double precio_unitario) {
        this.compra = compra;
        this.producto = producto;
        this.talla = talla;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }
}
