package entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "llenados")
@PrimaryKeyJoinColumn(name = "id_producto")
public class Llenado extends Producto implements Serializable {

    @Column(name = "litros", nullable = false)
    private Integer litros;
    
    @ManyToOne
    @JoinColumn(name = "id_contenedor", nullable = true)
    private Contenedor contenedor;

    public Llenado() {
    }

    public Llenado(String codigo, String nombre, Integer litros, Contenedor contenedor, float precio) {
        super(codigo, nombre, precio);
        this.litros = litros;
        this.contenedor = contenedor;
    }

    public Integer getLitros() {
        return litros;
    }

    public void setLitros(Integer litros) {
        this.litros = litros;
    }

    public Contenedor getContenedor() {
        return contenedor;
    }

    public void setContenedor(Contenedor contenedor) {
        this.contenedor = contenedor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.litros);
        hash = 37 * hash + Objects.hashCode(this.contenedor);
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
        final Llenado other = (Llenado) obj;
        if (!Objects.equals(this.litros, other.litros)) {
            return false;
        }
        return Objects.equals(this.contenedor, other.contenedor);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Llenado{");
        sb.append("codigo=").append(codigo);
        sb.append(", nombre=").append(nombre);
        sb.append(", precio=").append(precio);
        sb.append(", litros=").append(litros);
        sb.append(", contenedor=").append(contenedor);
        sb.append('}');
        return sb.toString();
    }

    
    
}
