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
@Table(name = "stockProductos")
public class StockProducto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoStock;

    @Column(name = "producto", nullable = false, length = 30)
    private Producto producto;
    
    @Column(name = "cantidad", nullable = false, length = 30)
    private int cantidad;
}
