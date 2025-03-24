package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "vendedores")
@PrimaryKeyJoinColumn(name = "id_usuario")
@DiscriminatorValue(value = "Vendedor")
public class Vendedor extends Usuario implements Serializable {
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "vendedor")
    private List<Venta> ventas;

    public Vendedor() {
    }

    public Vendedor(String nombre, String nombreUsuario, String contrasenia) {
        super(nombre, nombreUsuario, contrasenia);
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }
    
}
