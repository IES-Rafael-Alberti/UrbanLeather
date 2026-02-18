package backend.DTO;

import backend.model.Compra;
import backend.model.Producto;
import jakarta.persistence.*;

public class DetalleCompraDTO {

    private int id;
    private Compra compra;
    private Producto producto;
    private String talla;
    private int cantidad;
    private double precio_unitario;

    public DetalleCompraDTO(Compra compra, Producto producto, String talla, int cantidad, double precio_unitario) {
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
