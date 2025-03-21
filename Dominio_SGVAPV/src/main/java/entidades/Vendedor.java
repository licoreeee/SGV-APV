package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "vendedores")
@PrimaryKeyJoinColumn(name = "usuario_codigo")
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
