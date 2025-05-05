/*
 * ISubsistemaReporteVentasFacade.java
 */
package org.itson.subsistemareporteventas_sgvapv;

import dtos.ReporteVentasDTO;
import dtos.FiltroReportesDTO;

/**
 * @author Equipo1
 */
public interface ISubsistemaReporteVentasFacade {
    
    public ReporteVentasDTO obtenerVentas(FiltroReportesDTO filtro);
    
}
