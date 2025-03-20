package entidades;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Dell
 */
public class Venta {
    
    private String codigo;
    private List<Producto> productos;
    private float total;
    private Calendar fechaHora;
    private Usuario vendedor;

    public Venta(String codigo, List<Producto> productos, float total, Calendar fechaHora, Usuario vendedor) {
        this.codigo = codigo;
        this.productos = productos;
        this.total = total;
        this.fechaHora = fechaHora;
        this.vendedor = vendedor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }
    
    
    
}
