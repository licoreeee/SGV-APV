/*
 * ISubsistemaReporteVentasFacade.java
 */
package org.itson.subsistemareporteventas_sgvapv;

import dtos.VentaReporteDTO;
import dtos.FiltroReportesDTO;
import dtos.VentaDTO;
import java.util.List;

/**
 * @author Equipo1
 */
public interface ISubsistemaReporteVentasFacade {
    
    public List<VentaDTO> obtenerVentas(FiltroReportesDTO filtro);
    
    public void generarReporte(List<VentaReporteDTO> reporteVentas);
}
