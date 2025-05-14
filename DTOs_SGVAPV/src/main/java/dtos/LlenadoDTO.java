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
    private String codigoContenedorAsociado;
    
    public LlenadoDTO(Long id, String codigo, String nombre, Float precio, Integer litros) {
        super(id, codigo, nombre, precio);
        this.litros = litros;
    }
    
    public LlenadoDTO(String codigo, String nombre, Float precio, Integer litros, String codigoContenedorAsociado) {
        super(codigo, nombre, precio);
        this.litros = litros;
        this.codigoContenedorAsociado = codigoContenedorAsociado;
    }

    public LlenadoDTO(Integer litros, String codigoContenedorAsociado, Long id, String codigo, String nombre, Float precio) {
        super(id, codigo, nombre, precio);
        this.litros = litros;
        this.codigoContenedorAsociado = codigoContenedorAsociado;
    }

    public LlenadoDTO(Integer litros, String codigo, String nombre, Float precio) {
        super(codigo, nombre, precio);
    }

    public Long getId() {
        return id;
    }

    public Integer getLitros() {
        return litros;
    }

    public String getCodigoContenedorAsociado() {
        return codigoContenedorAsociado;
    }

    public void setCodigoContenedorAsociado(String codigoContenedorAsociado) {
        this.codigoContenedorAsociado = codigoContenedorAsociado;
    }

    @Override
    public String toString() {
        return getCodigo() + " - " + getNombre();
    }

}
