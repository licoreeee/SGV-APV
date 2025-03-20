package entidades;

/**
 *
 * @author Dell
 */
public class ProductoVenta {
    
    private float precio;
    private int cantidad;

    public ProductoVenta(float precio, int cantidad) {
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
