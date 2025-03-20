package entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "stockProductos")
public class StockProducto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoStock;

    @Column(name = "producto", nullable = false)
    private Producto producto;
    
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    public StockProducto() {
    }

    public StockProducto(Producto producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Long getCodigoStock() {
        return codigoStock;
    }

    public void setCodigoStock(Long codigoStock) {
        this.codigoStock = codigoStock;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.codigoStock);
        hash = 29 * hash + Objects.hashCode(this.producto);
        hash = 29 * hash + Objects.hashCode(this.cantidad);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StockProducto other = (StockProducto) obj;
        if (!Objects.equals(this.codigoStock, other.codigoStock)) {
            return false;
        }
        if (!Objects.equals(this.producto, other.producto)) {
            return false;
        }
        return Objects.equals(this.cantidad, other.cantidad);
    }

    @Override
    public String toString() {
        return "StockProducto{" + "codigoStock=" + codigoStock + ", producto=" + producto + ", cantidad=" + cantidad + '}';
    }
    
}
