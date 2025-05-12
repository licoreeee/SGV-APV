/**
 * VentaReporteDTO.java
 */
package dtos;

import java.util.Date;

/**
 *
 * @author ricar
 */
public class VentaReporteDTO {

    private Date fechaVenta;
    private String productos;
    private String cantidades;
    private Float total;

    public VentaReporteDTO() {
    }

    public VentaReporteDTO(Date fechaVenta, String productos, String cantidades, Float total) {
        this.fechaVenta = fechaVenta;
        this.productos = productos;
        this.cantidades = cantidades;
        this.total = total;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public String getCantidades() {
        return cantidades;
    }

    public void setCantidades(String cantidades) {
        this.cantidades = cantidades;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

}
