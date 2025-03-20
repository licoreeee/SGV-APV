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
@Table(name = "llenados")
public class Llenado extends Producto implements Serializable {

    @Column(name = "litros", nullable = false, length = 30)
    private int litros;
    
    @Column(name = "contenedor", nullable = true, length = 30)
    private Contenedor contenedor;

    public Llenado(int litros, Contenedor contenedor) {
        this.litros = litros;
        this.contenedor = contenedor;
    }

    public Llenado(int litros, Contenedor contenedor, float precio) {
        super(precio);
        this.litros = litros;
        this.contenedor = contenedor;
    }

    public int getLitros() {
        return litros;
    }

    public void setLitros(int litros) {
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
        int hash = 5;
        hash = 67 * hash + this.litros;
        hash = 67 * hash + Objects.hashCode(this.contenedor);
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
        if (this.litros != other.litros) {
            return false;
        }
        return Objects.equals(this.contenedor, other.contenedor);
    }

    @Override
    public String toString() {
        return "Llenado{" + "litros=" + litros + ", contenedor=" + contenedor + '}';
    }
    
}
