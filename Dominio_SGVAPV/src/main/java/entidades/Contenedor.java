package entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Dell
 */
@Entity
public class Contenedor extends Producto implements Serializable {

    public Contenedor() {
    }

    public Contenedor(float precio) {
        super(precio);
    }
    
}
