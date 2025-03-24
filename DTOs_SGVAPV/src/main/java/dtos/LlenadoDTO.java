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
        StringBuilder sb = new StringBuilder();
        sb.append("LlenadoDTO{");
        sb.append("codigo=").append(codigo);
        sb.append(", nombre=").append(nombre);
        sb.append(", precio=").append(precio);
        sb.append(", litros=").append(litros);
        sb.append('}');
        return sb.toString();
    }

}
