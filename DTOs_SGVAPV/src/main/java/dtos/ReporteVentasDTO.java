/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author ricar
 */
public class ReporteVentasDTO {
    
    private List<VentaDTO> ventas;
    private Float total;
    private Calendar fechaHoraInicio;
    private Calendar fechaHoraFin;
    private Calendar fechaHoraGeneracion;
    private EncargadoDTO encargado;

    public ReporteVentasDTO(List<VentaDTO> ventas, Float total, Calendar fechaHoraInicio, Calendar fechaHoraFin, Calendar fechaHoraGeneracion, EncargadoDTO encargado) {
        this.ventas = ventas;
        this.total = total;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.fechaHoraGeneracion = fechaHoraGeneracion;
        this.encargado = encargado;
    }

    public List<VentaDTO> getVentas() {
        return ventas;
    }

    public Float getTotal() {
        return total;
    }

    public Calendar getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public Calendar getFechaHoraFin() {
        return fechaHoraFin;
    }

    public Calendar getFechaHoraGeneracion() {
        return fechaHoraGeneracion;
    }

    public EncargadoDTO getEncargado() {
        return encargado;
    }
    
    
}
