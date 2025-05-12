/*
 * SubsistemaReporteVentasFacade.java
 */
package org.itson.subsistemareporteventas_sgvapv;

import dtos.VentaReporteDTO;
import dtos.FiltroReportesDTO;
import dtos.VentaDTO;
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
    public List<VentaDTO> obtenerVentas(FiltroReportesDTO filtro) {
        return control.obtenerVentas(filtro);
    }

    @Override
    public void generarReporte(List<VentaReporteDTO> ventas) {
        control.generarReporte(ventas);
    }
    
}
