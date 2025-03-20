package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "contenedores")
@PrimaryKeyJoinColumn(name = "producto_codigo")
public class Contenedor extends Producto implements Serializable {
    
    @OneToMany(mappedBy = "contenedor")
    private List<Llenado> llenados;

    public Contenedor() {
    }

    public Contenedor(Float precio) {
        super(precio);
    }

    public List<Llenado> getLlenados() {
        return llenados;
    }

    public void setLlenados(List<Llenado> llenados) {
        this.llenados = llenados;
    }
    
}
