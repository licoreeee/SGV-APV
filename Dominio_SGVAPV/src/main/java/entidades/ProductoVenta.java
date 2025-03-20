package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Dell
 */
@Embeddable
public class ProductoVenta implements Serializable {

    @Column(name = "precio", nullable = false)
    private Float precio;
    
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
    
    @ManyToOne
    @JoinColumn(name = "producto_codigo", nullable = false)
    private Producto producto;

    public ProductoVenta() {
    }

    public ProductoVenta(Float precio, Integer cantidad, Producto producto) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
}
