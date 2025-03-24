package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "contenedores")
@PrimaryKeyJoinColumn(name = "id_producto")
public class Contenedor extends Producto implements Serializable {

    @Column(name = "volumen", nullable = false)
    private Integer volumen;

    @OneToMany(mappedBy = "contenedor")
    private List<Llenado> llenados;

    public Contenedor() {
    }

    public Contenedor(String codigo, String nombre, Float precio, Integer volumen) {
        super(codigo, nombre, precio);
        this.volumen = volumen;
    }

    public Integer getVolumen() {
        return volumen;
    }

    public void setVolumen(Integer volumen) {
        this.volumen = volumen;
    }

    public List<Llenado> getLlenados() {
        return llenados;
    }

    public void setLlenados(List<Llenado> llenados) {
        this.llenados = llenados;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contenedor{");
        sb.append("codigo=").append(codigo);
        sb.append(", nombre=").append(nombre);
        sb.append(", precio=").append(precio);
        sb.append(", volumen=").append(volumen);
        sb.append('}');
        return sb.toString();
    }
    
    

}
