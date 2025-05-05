/*
 * LlenadoDTO.java
 */
package dtos;

/**
 *
 * @author Equipo1
 */
public class LlenadoDTO extends ProductoDTO {

    private Integer litros;

    public LlenadoDTO(String codigo, String nombre, Float precio, Integer litros) {
        super(codigo, nombre, precio);
        this.litros = litros;
    }

    public Integer getLitros() {
        return litros;
    }

    @Override
    public String toString() {
        return getCodigo() + " - " + getNombre();
    }

}
