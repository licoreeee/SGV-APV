/*
 * ISubsistemaReporteVentasFacade.java
 */
package org.itson.subsistemareporteventas_sgvapv;

import dtos.ProductoDTO;
import dtos.ReporteVentasDTO;
import java.util.Calendar;
import java.util.List;

/**
 * @author Equipo1
 */
public interface ISubsistemaReporteVentasFacade {
    
    public ReporteVentasDTO obtenerVentasPorPeriodo(Calendar fechaInicio, Calendar fechaFin);
    
    public ReporteVentasDTO obtenerVentasPorProductos(List<ProductoDTO> productos);
    
}
