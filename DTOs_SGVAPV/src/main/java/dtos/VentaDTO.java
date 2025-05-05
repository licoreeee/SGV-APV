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

    public VentaDTO() {
        productos = new ArrayList<>();
    }

    public VentaDTO(Float total, VendedorDTO vendedor) {
        this.total = total;
        this.fechaHora = new GregorianCalendar();
        this.vendedor = vendedor;
        productos = new ArrayList<>();
    }

    public VentaDTO(Float total, Calendar fechaHora, VendedorDTO vendedor, List<ProductoVentaDTO> productos) {
        this.total = total;
        this.fechaHora = fechaHora;
        this.vendedor = vendedor;
        this.productos = productos;
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

    public void agregarProducto(ProductoVentaDTO productoNuevo) {
        for (ProductoVentaDTO productoVenta : productos) {
            if (productoVenta.getProducto().getCodigo().equalsIgnoreCase(productoNuevo.getProducto().getCodigo())) {
                productoVenta.setCantidad(productoVenta.getCantidad() + productoNuevo.getCantidad());
                return;
            }
        }
        this.productos.add(productoNuevo);
    }

    public VendedorDTO getVendedor() {
        return vendedor;
    }

    public void setVendedor(VendedorDTO vendedor) {
        this.vendedor = vendedor;
    }

    public void actualizarTotal() {
        total = 0F;
        for (ProductoVentaDTO producto : productos) {
            total += producto.getCantidad() * producto.getPrecio();
        }
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

}
