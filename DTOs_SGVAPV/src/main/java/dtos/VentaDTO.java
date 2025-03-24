/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author ricar
 */
public class VentaDTO {

    private Float total;

    private Calendar fechaHora;

    private VendedorDTO vendedor;

    private List<ProductoVentaDTO> productos;

    public VentaDTO(Float total, VendedorDTO vendedor) {
        this.total = total;
        this.fechaHora = new GregorianCalendar();
        this.vendedor = vendedor;
        productos = new ArrayList<>();
    }

    public Float getTotal() {
        return total;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public List<ProductoVentaDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoVentaDTO> productos) {
        this.productos = productos;
    }

}
