package entidades;

import java.io.Serializable;
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
@Table(name = "variados")
public class Variado extends Producto implements Serializable {

    @Column(name = "codigo", nullable = false, length = 30)
    private String codigo;
    
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    public Variado() {
    }

    public Variado(float precio, String codigo, String nombre) {
        super(precio);
        this.codigo = codigo;
        this.nombre = nombre;
        
    }
  
}
