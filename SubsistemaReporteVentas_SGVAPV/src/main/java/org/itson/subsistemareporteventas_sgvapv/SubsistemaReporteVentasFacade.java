/*
 * SubsistemaReporteVentasFacade.java
 */
package org.itson.subsistemareporteventas_sgvapv;

import dtos.ProductoDTO;
import dtos.ReporteVentasDTO;
import java.util.Calendar;
import java.util.List;

/**
 * @author Equipo1
 */
public class SubsistemaReporteVentasFacade implements ISubsistemaReporteVentasFacade {

    private SubsistemaReporteVentasControl control;
    
    /**
     * Constructor.
     */
    public SubsistemaReporteVentasFacade() {
        control = new SubsistemaReporteVentasControl();
    }
    
    @Override
    public ReporteVentasDTO obtenerVentasPorPeriodo(Calendar fechaInicio, Calendar fechaFin) {
        return control.obtenerVentasPorPeriodo(fechaInicio, fechaFin);
    }

    @Override
    public ReporteVentasDTO obtenerVentasPorProductos(List<ProductoDTO> productos) {
        return control.obtenerVentasPorProductos(productos);
    }
    
}
