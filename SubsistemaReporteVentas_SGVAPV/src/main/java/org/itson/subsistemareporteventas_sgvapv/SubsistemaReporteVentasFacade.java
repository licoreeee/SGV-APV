/*
 * SubsistemaReporteVentasFacade.java
 */
package org.itson.subsistemareporteventas_sgvapv;

import dtos.ReporteVentasDTO;
import dtos.FiltroReportesDTO;

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
    public ReporteVentasDTO obtenerVentas(FiltroReportesDTO filtro) {
        return control.obtenerVentas(filtro);
    }
    
}
