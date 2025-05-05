package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "encargados")
@PrimaryKeyJoinColumn(name = "id_vendedor")
@DiscriminatorValue(value = "Encargado")
public class Encargado extends Vendedor implements Serializable {
    
    public Encargado() {
    }

    public Encargado(String nombre, String nombreUsuario, String contrasenia) {
        super(nombre, nombreUsuario, contrasenia);
    }
    
}
