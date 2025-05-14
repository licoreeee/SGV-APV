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

    public ContenedorDTO(Integer volumen, String codigo, String nombre, Float precio, Integer cantidad) {
        super(codigo, nombre, precio, cantidad);
        this.volumen = volumen;
    }    

    public ContenedorDTO(Long id, Integer volumen, String codigo, String nombre, Float precio) {
        super(id, codigo, nombre, precio);
        this.volumen = volumen;
    }

    public ContenedorDTO(Long id, Integer volumen, String codigo, String nombre, Float precio, Integer cantidad) {
        super(id, codigo, nombre, precio, cantidad);
        this.volumen = volumen;
    }

    public ContenedorDTO(Integer volumen, Long id, String codigo, String nombre, Float precio, Integer cantidad) {
        super(id, codigo, nombre, precio, cantidad);
        this.volumen = volumen;
    }

    public Long getId() {
        return id;
    }

    public Integer getVolumen() {
        return volumen;
    }

    @Override
    public String toString() {
        return getCodigo() + " - " + getNombre();
    }
    
}
