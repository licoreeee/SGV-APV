/*
 * ContenedorDTO.java
 */
package dtos;

/**
 *
 * @author Equipo1
 */
public class ContenedorDTO extends ProductoDTO {
    
    private Integer volumen;

    public ContenedorDTO(Integer volumen, String codigo, String nombre, Float precio) {
        super(codigo, nombre, precio);
        this.volumen = volumen;
    }

    public ContenedorDTO(Integer volumen, String codigo, String nombre, Float precio, Integer cantidad) {
        super(codigo, nombre, precio, cantidad);
        this.volumen = volumen;
    }

    @Override
    public String toString() {
        return getCodigo() + " - " + getNombre();
    }
    
    
}
