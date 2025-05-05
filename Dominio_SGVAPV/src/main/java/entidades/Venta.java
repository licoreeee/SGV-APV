package entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "ventas")
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "total", nullable = false)
    private Float total;

    @Column(name = "fechaHora", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaHora;

    @ManyToOne
    @JoinColumn(name = "vendedor_codigo", nullable = false)
    private Vendedor vendedor;

    @OneToMany(mappedBy = "venta", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<ProductoVenta> productos;
    
    public Venta() {
    }

    public Venta(Float total, Calendar fechaHora, Vendedor vendedor, List<ProductoVenta> productos) {
        this.total = total;
        this.fechaHora = fechaHora;
        this.vendedor = vendedor;
        this.productos = productos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<ProductoVenta> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoVenta> productos) {
        this.productos = productos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.total);
        hash = 67 * hash + Objects.hashCode(this.fechaHora);
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
        final Venta other = (Venta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        return Objects.equals(this.fechaHora, other.fechaHora);
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", total=" + total + ", fechaHora=" + fechaHora + '}';
    }

}
