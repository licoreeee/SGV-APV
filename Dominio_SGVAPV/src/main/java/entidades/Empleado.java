package entidades;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "empleados")
@PrimaryKeyJoinColumn(name = "id_vendedor")
@DiscriminatorValue(value = "Empleado")
public class Empleado extends Vendedor implements Serializable {

    public Empleado() {
    }

    public Empleado(String nombre, String nombreUsuario, String contrasenia) {
        super(nombre, nombreUsuario, contrasenia);
    }
    
}
