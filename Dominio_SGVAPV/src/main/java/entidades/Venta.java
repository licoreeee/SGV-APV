package entidades;

import java.io.Serializable;
import java.util.Calendar;
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
@Table(name = "ventas")
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigoVenta")
    private Long codigoVenta;

    @Column(name = "total", nullable = false)
    private Float total;
    
    @Column(name = "fechaHora", nullable = false)
    private Calendar fechaHora;

    public Venta() {
    }

    public Venta(Float total, Calendar fechaHora) {
        this.total = total;
        this.fechaHora = fechaHora;
    }

    public Long getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(Long codigoVenta) {
        this.codigoVenta = codigoVenta;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.codigoVenta);
        hash = 79 * hash + Objects.hashCode(this.total);
        hash = 79 * hash + Objects.hashCode(this.fechaHora);
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
        if (!Objects.equals(this.codigoVenta, other.codigoVenta)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        return Objects.equals(this.fechaHora, other.fechaHora);
    }

    @Override
    public String toString() {
        return "Venta{" + "codigoVenta=" + codigoVenta + ", total=" + total + ", fechaHora=" + fechaHora + '}';
    }
    
}
