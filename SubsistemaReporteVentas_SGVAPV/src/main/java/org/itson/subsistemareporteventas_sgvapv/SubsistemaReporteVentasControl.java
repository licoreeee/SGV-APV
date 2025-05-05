/*
 * SubsistemaReporteVentasControl.java
 */
package org.itson.subsistemareporteventas_sgvapv;

import dtos.ProductoDTO;
import dtos.ProductoVentaDTO;
import dtos.ReporteVentasDTO;
import dtos.VendedorDTO;
import dtos.VentaDTO;
import entidades.Producto;
import entidades.ProductoVenta;
import entidades.Venta;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import org.itson.accesodatos_sgvapv.daos.AccesoDatosFacade;
import org.itson.accesodatos_sgvapv.daos.IAccesoDatosFacade;

/**
 * @author Equipo1
 */
class SubsistemaReporteVentasControl {
    
    private IAccesoDatosFacade accesoDatos;

    public SubsistemaReporteVentasControl() {
        this.accesoDatos = new AccesoDatosFacade();
    }
    
    public ReporteVentasDTO obtenerVentasPorPeriodo(Calendar fechaInicio, Calendar fechaFin){
        List<Venta> ventasObtenidas = accesoDatos.obtenerVentasPeriodo(fechaInicio, fechaFin);
        
        if (ventasObtenidas != null && !ventasObtenidas.isEmpty()) {
            List<VentaDTO> ventas = new LinkedList<>();
            
            for (Venta venta : ventasObtenidas) {
                VendedorDTO vendedor = new VendedorDTO(venta.getVendedor().getNombre(), venta.getVendedor().getNombreUsuario(), venta.getVendedor().getContrasenia());
                List<ProductoVentaDTO> productosVenta = new LinkedList<>();
                
                for (ProductoVenta producto : venta.getProductos()) {
                    ProductoDTO productoVenta = new ProductoDTO(producto.getProducto().getCodigo(), producto.getProducto().getNombre(), producto.getProducto().getPrecio(), producto.getCantidad());
                    
                    productosVenta.add(new ProductoVentaDTO(producto.getPrecio(), producto.getCantidad(), productoVenta));
                }
                
                ventas.add(new VentaDTO(venta.getTotal(), venta.getFechaHora(), vendedor, productosVenta));
            }
            
            float total = 0.0f;
            
            for (VentaDTO venta : ventas) {
                total += venta.getTotal();
            }
            
            ReporteVentasDTO reporte = new ReporteVentasDTO(ventas, total, fechaInicio, fechaFin, new GregorianCalendar(), null);
            
            return reporte;
        } else {
            return null;
        }
    }
    
    public ReporteVentasDTO obtenerVentasPorProductos(List<ProductoDTO> productos) {
        List<Producto> productosBuscados = new LinkedList<>();
        
        for (ProductoDTO producto : productos) {
            productosBuscados.add(new Producto(producto.getCodigo(), producto.getNombre(), producto.getPrecio()));
        }
        
        List<Venta> ventasObtenidas = accesoDatos.obtenerVentasPorProductos(productosBuscados);
        
        if (ventasObtenidas != null && !ventasObtenidas.isEmpty()) {
            List<VentaDTO> ventas = new LinkedList<>();
            
            for (Venta venta : ventasObtenidas) {
                VendedorDTO vendedor = new VendedorDTO(venta.getVendedor().getNombre(), venta.getVendedor().getNombreUsuario(), venta.getVendedor().getContrasenia());
                List<ProductoVentaDTO> productosVenta = new LinkedList<>();
                
                for (ProductoVenta producto : venta.getProductos()) {
                    ProductoDTO productoVenta = new ProductoDTO(producto.getProducto().getCodigo(), producto.getProducto().getNombre(), producto.getProducto().getPrecio(), producto.getCantidad());
                    
                    productosVenta.add(new ProductoVentaDTO(producto.getPrecio(), producto.getCantidad(), productoVenta));
                }
                
                ventas.add(new VentaDTO(venta.getTotal(), venta.getFechaHora(), vendedor, productosVenta));
            }
            
            float total = 0.0f;
            
            for (VentaDTO venta : ventas) {
                total += venta.getTotal();
            }
            
            ReporteVentasDTO reporte = new ReporteVentasDTO(ventas, total, ventas.getFirst().getFechaHora(), ventas.getLast().getFechaHora(), new GregorianCalendar(), null);
            
            return reporte;
        } else {
            return null;
        }
    }
}
