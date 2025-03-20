package entidades;

import java.io.Serializable;
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
@Table(name = "encargados")
public class Encargado extends Usuario implements Serializable {

    public Encargado() {
    }

    public Encargado(String nombre, String nombreUsuario, String contrasenia) {
        super(nombre, nombreUsuario, contrasenia);
    }
    
}
