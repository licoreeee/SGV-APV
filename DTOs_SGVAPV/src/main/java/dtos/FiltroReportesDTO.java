/*
 * FiltroReportes.java
 */
package dtos;

import dtos.ProductoDTO;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author ricar
 */
public class FiltroReportesDTO {
    
    private Calendar fechaInicio;
    private Calendar fechaFin;
    private List<ProductoDTO> productos;

    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Calendar getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Calendar fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<ProductoDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoDTO> productos) {
        this.productos = productos;
    }
    
}
