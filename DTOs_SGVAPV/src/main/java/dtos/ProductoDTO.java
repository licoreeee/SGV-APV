/*
 * ProductoDTO.java
 */
package dtos;

import java.util.Objects;

/**
 *
 * @author Equipo1
 */
public class ProductoDTO {

    protected Long id;
    protected String codigo;
    protected String nombre;
    protected Float precio;
    protected Integer cantidad;
    protected String tipoEspecifico;

    public ProductoDTO(Long id, String codigo, String nombre, Float precio, Integer cantidad, String tipoEspecifico) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.tipoEspecifico = tipoEspecifico;
    }

    public ProductoDTO(Long id, String codigo, String nombre, Float precio) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public ProductoDTO(Long id, String codigo, String nombre, Float precio, Integer cantidad) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public ProductoDTO(String codigo, String nombre, Float precio, Integer cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }   

    public ProductoDTO(String codigo, String nombre, Float precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoEspecifico() {
        return tipoEspecifico;
    }

    public void setTipoEspecifico(String tipoEspecifico) {
        this.tipoEspecifico = tipoEspecifico;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductoDTO other = (ProductoDTO) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    @Override
    public String toString() {
        return getCodigo() + " - " + getNombre();
    }

}
