package entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "reportes")
public class ReporteVentas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    @ManyToMany
    @JoinTable(
        name = "reporteVentas_ventas",
        joinColumns = @JoinColumn(name = "reporteVentas_codigo"),
        inverseJoinColumns = @JoinColumn(name = "venta_codigo")
    )
    private List<Venta> ventas;
    
    @Column(name = "total", nullable = false)
    private Float total;
    
    @Column(name = "fechaHoraInicio", nullable = false)
    private Calendar fechaHoraInicio;
    
    @Column(name = "fechaHoraFin", nullable = false)
    private Calendar fechaHoraFin;
    
    @Column(name = "fechaHoraGeneracion", nullable = false)
    private Calendar fechaHoraGeneracion;
    
    @Column(name = "encargado", nullable = false)
    private Encargado encargado;

    public ReporteVentas() {
    }

    public ReporteVentas(List<Venta> ventas, Float total, Calendar fechaHoraInicio, Calendar fechaHoraFin, Calendar fechaHoraGeneracion, Encargado encargado) {
        this.ventas = ventas;
        this.total = total;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.fechaHoraGeneracion = fechaHoraGeneracion;
        this.encargado = encargado;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Calendar getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(Calendar fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public Calendar getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(Calendar fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public Calendar getFechaHoraGeneracion() {
        return fechaHoraGeneracion;
    }

    public void setFechaHoraGeneracion(Calendar fechaHoraGeneracion) {
        this.fechaHoraGeneracion = fechaHoraGeneracion;
    }

    public Encargado getEncargado() {
        return encargado;
    }

    public void setEncargado(Encargado encargado) {
        this.encargado = encargado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        hash = 97 * hash + Objects.hashCode(this.ventas);
        hash = 97 * hash + Objects.hashCode(this.total);
        hash = 97 * hash + Objects.hashCode(this.fechaHoraInicio);
        hash = 97 * hash + Objects.hashCode(this.fechaHoraFin);
        hash = 97 * hash + Objects.hashCode(this.fechaHoraGeneracion);
        hash = 97 * hash + Objects.hashCode(this.encargado);
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
        final ReporteVentas other = (ReporteVentas) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.ventas, other.ventas)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        if (!Objects.equals(this.fechaHoraInicio, other.fechaHoraInicio)) {
            return false;
        }
        if (!Objects.equals(this.fechaHoraFin, other.fechaHoraFin)) {
            return false;
        }
        if (!Objects.equals(this.fechaHoraGeneracion, other.fechaHoraGeneracion)) {
            return false;
        }
        return Objects.equals(this.encargado, other.encargado);
    }

    @Override
    public String toString() {
        return "ReporteVentas{" + "codigo=" + codigo + ", ventas=" + ventas + ", total=" + total + ", fechaHoraInicio=" + fechaHoraInicio + ", fechaHoraFin=" + fechaHoraFin + ", fechaHoraGeneracion=" + fechaHoraGeneracion + ", encargado=" + encargado + '}';
    }
    
}
