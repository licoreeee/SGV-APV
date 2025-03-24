package entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "variados")
@PrimaryKeyJoinColumn(name = "id_producto")
public class Variado extends Producto implements Serializable {

    public Variado() {
    }

    public Variado(String codigo, String nombre, Float precio) {
        super(codigo, nombre, precio);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Variado{");
        sb.append("codigo=").append(codigo);
        sb.append(", nombre=").append(nombre);
        sb.append(", precio=").append(precio);
        sb.append('}');
        return sb.toString();
    }

}
