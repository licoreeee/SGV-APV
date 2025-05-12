/*
 * SubsistemaVentasControl.java
 */
package org.itson.subsistemaventas_sgvapv;

import dtos.ProductoDTO;
import dtos.ProductoVentaDTO;
import dtos.VariadoDTO;
import dtos.VentaDTO;
import entidades.Contenedor;
import entidades.Llenado;
import entidades.Producto;
import entidades.ProductoVenta;
import entidades.Variado;
import entidades.Vendedor;
import entidades.Venta;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.itson.accesodatos_sgvapv.daos.IAccesoDatosFacade;
import org.itson.accesodatos_sgvapv.daos.AccesoDatosFacade;
import org.itson.accesodatos_svgapv.excepciones.PersistenciaException;
import org.itson.subsistemaventas_sgvapv.excepciones.SubsistemaVentasException;

/**
 *
 * @author Equipo1
 */
class SubsistemaVentasControl {

    private IAccesoDatosFacade accesoDatos;

    public SubsistemaVentasControl() {
        accesoDatos = new AccesoDatosFacade();
    }

    public ProductoDTO obtenerProducto(String codigo) {
        Producto productoObtenido = accesoDatos.obtenerProducto(codigo);

        if (productoObtenido instanceof Variado) {
            VariadoDTO variado = new VariadoDTO(productoObtenido.getId(), productoObtenido.getCodigo(), productoObtenido.getNombre(), productoObtenido.getPrecio());
        } else if (productoObtenido instanceof Contenedor) {

        } else if (productoObtenido instanceof Llenado) {

        }
        return null;
    }

    public void agregarProducto(ProductoDTO producto) throws SubsistemaVentasException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void actualizarProducto(ProductoDTO producto) throws SubsistemaVentasException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void eliminarProducto(String codigo) throws SubsistemaVentasException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<ProductoDTO> obtenerProductosPorTipo(List<String> tipos) {
        List<Class> tiposSeleccionados = new LinkedList();
        for (String tipo : tipos) {
            if (tipo.equalsIgnoreCase("VARIADO")) {
                tiposSeleccionados.add(Variado.class);
            }
            if (tipo.equalsIgnoreCase("LLENADO")) {
                tiposSeleccionados.add(Llenado.class);
            }
            if (tipo.equalsIgnoreCase("CONTENEDOR")) {
                tiposSeleccionados.add(Contenedor.class);
            }

        }
        
        List<Producto> listaProductos = accesoDatos.obtenerProductosPorTipo(tiposSeleccionados);
        
        if (listaProductos != null) {
            List<ProductoDTO> listaProductosDTO = new LinkedList();
            for (Producto producto : listaProductos) {
                if (producto.getStock().getCantidad() > 0) {
                    listaProductosDTO.add(new ProductoDTO(producto.getId(), producto.getCodigo(), producto.getNombre(), producto.getPrecio(), producto.getStock().getCantidad()));
                }
            }
            return listaProductosDTO;
        }
        return null;
    }

    public List<ProductoDTO> obtenerProductosPorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void realizarVenta(VentaDTO ventaDTO) {
        try {
            Vendedor vendedor = accesoDatos.obtenerVendedor(ventaDTO.getVendedor().getNombreUsuario());

            Venta venta = new Venta();
            venta.setFechaHora(ventaDTO.getFechaHora());
            venta.setTotal(ventaDTO.getTotal());
            venta.setVendedor(vendedor);
            List<ProductoVenta> productosVentaEntidad = convertirProductosDTOAEntidad(ventaDTO.getProductos());
            for (ProductoVenta productoVentaEntidad : productosVentaEntidad) {
                productoVentaEntidad.setVenta(venta);
            }
            venta.setProductos(productosVentaEntidad);

            accesoDatos.agregarVenta(venta);
        } catch (PersistenciaException ex) {

        }
    }

    private List<ProductoVenta> convertirProductosDTOAEntidad(List<ProductoVentaDTO> productosVentaDTO) {
        List<ProductoVenta> productosEntidad = new ArrayList<>();
        for (ProductoVentaDTO productoVentaDTO : productosVentaDTO) {
            ProductoVenta productoVenta = new ProductoVenta();
            productoVenta.setCantidad(productoVentaDTO.getCantidad());
            productoVenta.setPrecio(productoVentaDTO.getPrecio());
            productoVenta.setProducto(accesoDatos.obtenerProducto(productoVentaDTO.getProducto().getCodigo()));
            productosEntidad.add(productoVenta);
        }
        return productosEntidad;
    }

}
