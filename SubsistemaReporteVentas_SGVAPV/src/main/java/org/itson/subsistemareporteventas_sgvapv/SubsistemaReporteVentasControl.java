/*
 * SubsistemaReporteVentasControl.java
 */
package org.itson.subsistemareporteventas_sgvapv;

import auxiliares.FiltroReportes;
import dtos.ProductoDTO;
import dtos.ProductoVentaDTO;
import dtos.ReporteVentasDTO;
import dtos.VendedorDTO;
import dtos.VentaDTO;
import entidades.ProductoVenta;
import entidades.Venta;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import org.itson.accesodatos_sgvapv.daos.AccesoDatosFacade;
import org.itson.accesodatos_sgvapv.daos.IAccesoDatosFacade;
import dtos.FiltroReportesDTO;
import entidades.Producto;

/**
 * @author Equipo1
 */
class SubsistemaReporteVentasControl {

    private IAccesoDatosFacade accesoDatos;

    public SubsistemaReporteVentasControl() {
        this.accesoDatos = new AccesoDatosFacade();
    }

    public ReporteVentasDTO obtenerVentas(FiltroReportesDTO filtro) {
        FiltroReportes filtroReportes = new FiltroReportes();
        
        if (filtro.getFechaInicio() != null && filtro.getFechaFin() != null){
            filtroReportes.setFechaInicio(filtro.getFechaInicio());
            filtroReportes.setFechaFin(filtro.getFechaFin());
        }
        
        if (filtro.getProductos() != null && !filtro.getProductos().isEmpty()) {
            List<Producto> productosFiltro = new LinkedList<>();
            
            for (ProductoDTO producto : filtro.getProductos()) {
                productosFiltro.add(new Producto(producto.getCodigo(), producto.getNombre(), producto.getPrecio()));
            }
        
            filtroReportes.setProductos(productosFiltro);
        }
        
        List<Venta> ventasObtenidas = accesoDatos.obtenerVentas(filtroReportes);

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

            ReporteVentasDTO reporte = new ReporteVentasDTO(ventas, total, filtro.getFechaInicio(), filtro.getFechaFin(), new GregorianCalendar(), null);

            return reporte;
        } else {
            return null;
        }
    }

}
