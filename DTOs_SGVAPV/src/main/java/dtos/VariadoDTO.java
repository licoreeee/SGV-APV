/*
 * VariadoDTO
 */
package dtos;

/**
 *
 * @author Equipo1
 */
public class VariadoDTO extends ProductoDTO {

    public VariadoDTO(Long id, String codigo, String nombre, Float precio) {
        super(id, codigo, nombre, precio);
    }

    public VariadoDTO(Long id, String codigo, String nombre, Float precio, Integer cantidad) {
        super(id, codigo, nombre, precio, cantidad);
    }

    @Override
    public String toString() {
        return getCodigo() + " - " + getNombre();
    }
    
    
}
