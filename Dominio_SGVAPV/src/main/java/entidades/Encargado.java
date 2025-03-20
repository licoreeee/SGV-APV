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
@Table(name = "encargados")
@PrimaryKeyJoinColumn(name = "vendedor_codigo")
public class Encargado extends Vendedor implements Serializable {
    
    @OneToMany(mappedBy = "encargado")
    private List<ReporteVentas> reportes;

    public Encargado() {
    }

    public Encargado(String nombre, String nombreUsuario, String contrasenia) {
        super(nombre, nombreUsuario, contrasenia);
    }

    public List<ReporteVentas> getReportes() {
        return reportes;
    }

    public void setReportes(List<ReporteVentas> reportes) {
        this.reportes = reportes;
    }
    
}
