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
        StringBuilder sb = new StringBuilder();
        sb.append("VariadoDTO{");
        sb.append("codigo=").append(codigo);
        sb.append(", nombre=").append(nombre);
        sb.append(", precio=").append(precio);
        sb.append(", cantidad=").append(cantidad);
        sb.append('}');
        return sb.toString();
    }
    
    
}
