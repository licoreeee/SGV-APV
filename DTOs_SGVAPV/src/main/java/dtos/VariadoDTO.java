/*
 * VariadoDTO
 */
package dtos;

/**
 *
 * @author Equipo1
 */
public class VariadoDTO extends ProductoDTO {

    public VariadoDTO(String codigo, String nombre, Float precio) {
        super(codigo, nombre, precio);
    }

    public VariadoDTO(String codigo, String nombre, Float precio, Integer cantidad) {
        super(codigo, nombre, precio, cantidad);
    }

    @Override
    public String toString() {
        return getCodigo() + " - " + getNombre();
    }
    
    
}
